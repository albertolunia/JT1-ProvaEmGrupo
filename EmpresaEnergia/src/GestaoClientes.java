package EmpresaEnergia.src;

import java.util.ArrayList;

public class GestaoClientes {
    static ArrayList<Cliente> clientes = new ArrayList<>();

    public static boolean addCliente(Cliente cliente) {
        if (getCliente(cliente.getCpf()) != null) {
            return false;
        }
        return clientes.add(cliente);
    }

    public static boolean removeCliente(Cliente cliente) {
        return clientes.remove(cliente);
    }

    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public static Cliente getCliente(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    public static void ListarClientes() {
        for (Cliente cliente : clientes) {
            System.out.println(cliente.toString());
        }
    }
}
