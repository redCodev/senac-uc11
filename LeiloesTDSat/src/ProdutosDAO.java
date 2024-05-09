
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProdutosDAO {

    private static PreparedStatement prep;
    private static ResultSet resultSet;

    public boolean cadastrarProduto(ProdutosDTO produto) {
        conectaDAO to = new conectaDAO();
        final String insertProduto = "INSERT INTO produtos(nome, valor, status) VALUES(?,?,?);";
        try (Connection conn = to.connectDB()) {
            prep = conn.prepareStatement(insertProduto);
            prep.setString(1, produto.getNome());
            prep.setInt(2, produto.getValor());
            prep.setString(3, "A Venda");

            prep.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            return false;
        }
    }

    public static List<ProdutosDTO> listagem() {
        conectaDAO to = new conectaDAO();
        final String listProducts = "SELECT * FROM produtos;";
        List<ProdutosDTO> lista = new ArrayList<>();
        try (Connection conn = to.connectDB()) {
            prep = conn.prepareStatement(listProducts);
            resultSet = prep.executeQuery();
            while (resultSet.next()) {
                ProdutosDTO produto = new ProdutosDTO();
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                int valor = resultSet.getInt("valor");
                String status = resultSet.getString("status");
                produto.setNome(nome);
                produto.setValor(valor);
                produto.setStatus(status);
                lista.add(produto);
            }
            return lista;
        } catch (SQLException ex) {
            return null;
        }
    }
}
