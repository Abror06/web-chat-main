package com.akhrullo.webchat.auth.oauth;

import com.akhrullo.webchat.config.JwtService;
import com.akhrullo.webchat.session.CookieManagementService;
import com.akhrullo.webchat.token.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class CustomOAuth2SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private final JwtService jwtService;
    private final TokenService tokenService;
    private final CookieManagementService cookieManagementService;

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication
    ) throws IOException {
        // Retrieve the authenticated OAuth2User
        CustomOAuth2User oAuth2User = (CustomOAuth2User) authentication.getPrincipal();

        // Generate JWT tokens
        String jwtToken = jwtService.generateToken(oAuth2User.getUser());
        String refreshToken = jwtService.generateRefreshToken(oAuth2User.getUser());

        tokenService.revokeAndSaveNewToken(oAuth2User.getUser(), jwtToken);

        // Add cookies
        cookieManagementService.setAccessTokenCookie(response, jwtToken);
        cookieManagementService.setRefreshTokenCookie(response, refreshToken);

        getRedirectStrategy().sendRedirect(request, response, "/chat");
    }
}
