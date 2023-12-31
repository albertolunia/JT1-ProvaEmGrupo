package EmpresaEnergia.src;

import java.util.ArrayList;

public class GestaoImoveis {
    private static ArrayList<Imovel> imoveis = new ArrayList<>();

    public static boolean addImovel(Imovel imovel) {
        if (getImovel(imovel.getMatricula()) != null)
            return false;
        else
            return imoveis.add(imovel);
    }

    public static boolean removeImovel(Imovel imovel) {
        return imoveis.remove(imovel);
    }

    public static ArrayList<Imovel> getImoveis() {
        return imoveis;
    }

    public static Imovel getImovel(String matricula) {
        for (Imovel imovel : imoveis) {
            if (imovel.getMatricula().equals(matricula))
                return imovel;
        }
        return null;
    }

    public static void ListarImoveis() {
        for (Imovel imovel : imoveis) {
            System.out.println(imovel.toString());
        }
    }
    public static void ListarReparosEmAberto(){
        for (Imovel imovel : imoveis) {
            imovel.ListarReparosEmAberto();
        }

    }

    public static void ListarFalhas(){
        for (Imovel imovel : imoveis) {
            imovel.ListarFalhas();
        }
    }

    public static void listarPagamentos(){
        for (Imovel imovel : imoveis) {
            imovel.listarPagamentos();
        }
    }
}
