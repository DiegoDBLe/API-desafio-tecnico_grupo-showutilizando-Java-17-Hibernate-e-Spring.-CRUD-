//package com.desafio.veiculo_api.config;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import com.desafio.veiculo_api.entity.Usuario;
//import com.desafio.veiculo_api.repository.UsuarioRepository;
//
//@Configuration
//public class DataLoader {
//
//    @Bean
//    public CommandLineRunner loadUser(
//            UsuarioRepository usuarioRepository,
//            PasswordEncoder passwordEncoder) {
//
//        return args -> {
//            if (usuarioRepository.findByUsername("admin").isEmpty()) {
//                Usuario usuario = new Usuario();
//                usuario.setUsername("admin");
//                usuario.setPassword(passwordEncoder.encode("123456"));
//                usuarioRepository.save(usuario);
//
//                System.out.println(">>> Usuário admin criado");
//            }
//        };
//    }
//}
