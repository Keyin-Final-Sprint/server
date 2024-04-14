package com.keyin.server;

import com.keyin.server.config.OAuth2LoginSuccessHandler;
import com.keyin.server.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2UserAuthority;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;

@ActiveProfiles("local")
public class OAuth2LoginSuccessHandlerTest {
    @Mock
    private UserService userService;
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private OAuth2AuthenticationToken authentication;
    @InjectMocks
    private OAuth2LoginSuccessHandler successHandler;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        ReflectionTestUtils.setField(successHandler, "frontendUrl", "http://localhost:3000");
    }

    @Test
    public void testOnAuthenticationSuccess() throws Exception {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("email", "user@example.com");
        attributes.put("username", "user");
        attributes.put("id", "1");

        DefaultOAuth2User principal = new DefaultOAuth2User(
                Collections.singletonList(new OAuth2UserAuthority(attributes)),
                attributes,
                "id"
        );

        when(authentication.getPrincipal()).thenReturn(principal);
        when(authentication.getAuthorizedClientRegistrationId()).thenReturn("github");

        successHandler.onAuthenticationSuccess(request, response, authentication);

        verify(userService).findByEmail("user@example.com");
    }
}




