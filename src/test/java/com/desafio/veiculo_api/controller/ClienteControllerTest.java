package com.desafio.veiculo_api.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import com.desafio.veiculo_api.security.JwtService;


@SpringBootTest
class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private JwtService jwtService;

    @Test
    @WithMockUser
    void deveListarClientes_comSucesso() throws Exception {
        mockMvc.perform(
                get("/api/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }
}
