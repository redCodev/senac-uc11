
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProdutosDAO {

    PreparedStatement prep;
    ResultSet resultset;

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
}
