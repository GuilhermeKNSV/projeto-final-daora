
package br.senai.sistema.config;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import br.senai.sistema.model.Servico;
import br.senai.sistema.model.Perfil;
import br.senai.sistema.model.Usuario;
import br.senai.sistema.repository.ServicoRepository;
import br.senai.sistema.repository.UsuarioRepository;

@Component
public class DadosIniciais implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final ServicoRepository servicoRepository;

    public DadosIniciais(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder,
                         ServicoRepository servicoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.servicoRepository = servicoRepository;
    }

    @Override
    public void run(String... args) {
        if (usuarioRepository.count() == 0) {
            usuarioRepository.save(new Usuario("Administrador", "admin",
                    passwordEncoder.encode("admin123"), Perfil.ADMIN));
            usuarioRepository.save(new Usuario("Operador", "operador",
                    passwordEncoder.encode("operador123"), Perfil.OPERADOR));
        }

        if (servicoRepository.count() == 0) {
            Servico servico1 = new Servico("Corte Masculino", "Corte de cabelo masculino", 30, new BigDecimal("35.00"));
            Servico servico2 = new Servico("Barba", "Aparar e fazer a barba", 20, new BigDecimal("25.00"));
            Servico servico3 = new Servico("Corte + Barba", "Corte de cabelo e barba", 50, new BigDecimal("55.00"));

            servicoRepository.save(servico1);
            servicoRepository.save(servico2);
            servicoRepository.save(servico3);
        }
    }
}
