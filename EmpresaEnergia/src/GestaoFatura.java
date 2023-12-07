package EmpresaEnergia.src;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GestaoFatura {
    
        private static List<Fatura> faturas = new ArrayList<>();
    
    
        public static boolean addFatura(Fatura fatura) {
            return faturas.add(fatura);
        }
    
        public static void listarTodasFaturas() {
            for (Fatura fatura : faturas) {
                System.out.println(fatura);
            }
        }
    
        public static void listarFaturasEmAberto() {
            List<Fatura> faturasEmAberto = faturas.stream()
                    .filter(fatura -> !fatura.isQuitado())
                    .collect(Collectors.toList());
    
            for (Fatura fatura : faturasEmAberto) {
                System.out.println(fatura);
            }
        }
    }