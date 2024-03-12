import java.sql.*;
import java.math.BigDecimal;
import java.util.ArrayList;

public class ItemDAO
{
    private Connection connection;

    public ItemDAO(Connection connection)
    {
        this.connection = connection;
    }

    public void create(Item item)
    {
        String sql = "INSERT INTO ITEM (TITLE, RELEASEDATE, LISTPRICE, PRICE, VERSION) VALUES (?, ?, ?, ?, ?)";
        try
        {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, item.getTitle());
            stmt.setDate(2, new java.sql.Date(item.getReleaseDate().getTime()));
            stmt.setBigDecimal(3, new BigDecimal(String.valueOf(item.getPrice())));
            stmt.setBigDecimal(4, new BigDecimal(String.valueOf(item.getPrice())));
            stmt.setInt(5, 1);

            int rowsInserted = stmt.executeUpdate();
            System.out.println("Rows inserted: " + rowsInserted);

            connection.commit();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public ArrayList<Item> searchByKeyword(String keyword)
    {
        ArrayList<Item> items = new ArrayList<>();
        String sql = "SELECT * FROM ITEM WHERE TITLE LIKE ?";
        try
        {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, "%" + keyword + "%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next())
            {
                Item item = new Item(rs.getInt("item_id"),
                        rs.getString("title"),
                        rs.getString("artist"),
                        rs.getDate("releasedate"),
                        rs.getBigDecimal("listprice"),
                        rs.getDouble("version"));
                items.add(item);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return items;
    }
}
