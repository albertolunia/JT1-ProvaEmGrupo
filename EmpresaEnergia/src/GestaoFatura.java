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
        public static void listarPagamentos(int id){
            int idAtual = 0;
            for (Fatura fatura : faturas) {
                if (id == idAtual){
                    fatura.listarPagamentos();
                    return;
                }
                idAtual++;
            }
        }

        public static void listarReembolso(int id){
            int idAtual = 0;
            for (Fatura fatura : faturas) {
                if (id == idAtual){
                    fatura.listarReembolso();
                    return;
                }
                idAtual++;
            }
        }

        public static void listarReembolsos(){
            for (Fatura fatura : faturas) {
                fatura.listarReembolso();
            }
        }
    }