package EmpresaEnergia.src;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GestaoFatura {
    
        private List<Fatura> faturas = new ArrayList<>();
    
    
        public Fatura criarFatura(int ultimaLeitura, int penultimaLeitura) {
            Fatura fatura = new Fatura(ultimaLeitura, penultimaLeitura);
            faturas.add(fatura);
            return fatura;
        }
    
        public void listarTodasFaturas() {
            for (Fatura fatura : faturas) {
                System.out.println(fatura);
            }
        }
    
        public void listarFaturasEmAberto() {
            List<Fatura> faturasEmAberto = faturas.stream()
                    .filter(fatura -> !fatura.isQuitado())
                    .collect(Collectors.toList());
    
            for (Fatura fatura : faturasEmAberto) {
                System.out.println(fatura);
            }
        }
    }