package fatura;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GestaoFatura {
    
        private List<Fatura> faturas;
    
        public GestaoFatura() {
            this.faturas = new ArrayList<>();
        }
    
        public void criarFatura(Imovel imovel, int leituraAtual) {
            int ultimaLeitura = imovel.getUltimaLeitura();
            int penultimaLeitura = imovel.getPenultimaLeitura();
    
            // Atualiza as leituras no imóvel
            imovel.setPenultimaLeitura(ultimaLeitura);
            imovel.setUltimaLeitura(leituraAtual);
    
            // Cria a fatura
            Fatura novaFatura = new Fatura(ultimaLeitura, penultimaLeitura);
            faturas.add(novaFatura);
    
            System.out.println("Fatura criada com sucesso!");
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
    


