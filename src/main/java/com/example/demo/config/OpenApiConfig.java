// // package com.example.demo.config;

// // import io.swagger.v3.oas.models.OpenAPI;
// // import io.swagger.v3.oas.models.servers.Server;
// // import org.springframework.context.annotation.Bean;
// // import org.springframework.context.annotation.Configuration;

// // import java.util.List;

// // @Configuration
// // public class OpenApiConfig {

// //     @Bean
// //     public OpenAPI customOpenAPI() {

// //         Server server = new Server();
// //         server.setUrl("https://9069.pro604cr.amypo.ai");

// //         return new OpenAPI()
// //                 .servers(List.of(server));
// //     }
// // }


// package com.example.demo.config;

// import io.swagger.v3.oas.models.Components;
// import io.swagger.v3.oas.models.OpenAPI;
// import io.swagger.v3.oas.models.info.Info;
// import io.swagger.v3.oas.models.security.SecurityScheme;
// import io.swagger.v3.oas.models.security.SecurityRequirement;

// import io.swagger.v3.oas.models.servers.Server;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// import java.util.List;

// @Configuration
// public class OpenApiConfig {

// @Bean
// public OpenAPI customOpenAPI() {

//     Server server = new Server();
//     server.setUrl("https://9069.pro604cr.amypo.ai");

//     SecurityScheme securityScheme = new SecurityScheme()
//             .type(SecurityScheme.Type.HTTP)
//             .scheme("bearer")
//             .bearerFormat("JWT")
//             .description("Enter JWT token");

//     return new OpenAPI()
//             .info(new Info()
//                     .title("JWT Demo API")
//                     .version("1.0")
//                     .description("Simple JWT Demo Project for Students"))
//             .serve  rs(List.of(server))
//             // ✅ THIS LINE IS THE FIX
//             .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
//             .components(new Components()
//                     .addSecuritySchemes("bearerAuth", securityScheme));
// }

// }


package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("JWT Demo API")
                        .version("1.0")
                        .description("Simple JWT Demo Project for Students"))
                .servers(List.of(
                        // ✅ YOUR URL — unchanged
                        new Server().url("https://9069.pro604cr.amypo.ai")
                ))
                // ✅ Define JWT scheme ONLY (same pattern as reference)
                .components(new io.swagger.v3.oas.models.Components()
                        .addSecuritySchemes("Bearer Authentication",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")));
    }
}
