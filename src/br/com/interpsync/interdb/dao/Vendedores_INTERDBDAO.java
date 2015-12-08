/*  1:   */ package br.com.interpsync.interdb.dao;
/*  2:   */ 
/*  3:   */ import br.com.interpsync.interdb.jdbc.ConnectionFactoryInterDB;
/*  4:   */ import br.com.interpsync.retreadsystem.modelo.Vendedores_ERP;
/*  5:   */ import java.sql.Connection;
/*  6:   */ import java.sql.PreparedStatement;
/*  7:   */ import java.sql.ResultSet;
/*  8:   */ import java.sql.SQLException;
/*  9:   */ import java.util.logging.Level;
/* 10:   */ import java.util.logging.Logger;
/* 11:   */ 
/* 12:   */ public class Vendedores_INTERDBDAO
/* 13:   */ {
/* 14:   */   private Connection connection;
/* 15:   */   
/* 16:   */   public Vendedores_INTERDBDAO()
/* 17:   */   {
/* 18:   */     try
/* 19:   */     {
/* 20:25 */       this.connection = ConnectionFactoryInterDB.getInstance().obterConexao();
/* 21:   */     }
/* 22:   */     catch (SQLException ex)
/* 23:   */     {
/* 24:27 */       Logger.getLogger(Clientes_INTERDBDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 25:   */     }
/* 26:   */     catch (ClassNotFoundException ex)
/* 27:   */     {
/* 28:29 */       Logger.getLogger(Clientes_INTERDBDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 29:   */     }
/* 30:   */     catch (Exception ex)
/* 31:   */     {
/* 32:31 */       Logger.getLogger(Clientes_INTERDBDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 33:   */     }
/* 34:   */   }
/* 35:   */   
/* 36:   */   public Connection getConnection()
/* 37:   */     throws SQLException, ClassNotFoundException, Exception
/* 38:   */   {
/* 39:39 */     if ((this.connection == null) || (this.connection.isClosed())) {
/* 40:40 */       this.connection = ConnectionFactoryInterDB.getInstance().obterConexao();
/* 41:   */     }
/* 42:42 */     return this.connection;
/* 43:   */   }
/* 44:   */   
/* 45:   */   public void inserir(Vendedores_ERP vendedor)
/* 46:   */     throws ClassNotFoundException, Exception, SQLException
/* 47:   */   {
/* 48:49 */     String sql = "INSERT INTO VENDEDORES_ERP (CodVE, NomeVE, RegiaoVE, StEI) VALUES (?, ?, ?, ?)";
/* 49:50 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 50:51 */     stmt.setString(1, vendedor.getCodVE());
/* 51:52 */     stmt.setString(2, vendedor.getNomeVE());
/* 52:53 */     stmt.setString(3, vendedor.getRegiaoVE());
/* 53:54 */     stmt.setInt(4, vendedor.getStEI());
/* 54:55 */     stmt.executeUpdate();
/* 55:56 */     stmt.close();
/* 56:   */   }
/* 57:   */   
/* 58:   */   public Vendedores_ERP findbyid(String id)
/* 59:   */     throws ClassNotFoundException, Exception, SQLException
/* 60:   */   {
/* 61:63 */     String sql = "SELECT CodVE, NomeVE, RegiaoVE, StEI FROM VENDEDORES_ERP WHERE CodVE = ?";
/* 62:64 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 63:65 */     stmt.setString(1, id);
/* 64:66 */     stmt.executeQuery();
/* 65:67 */     ResultSet rs = stmt.getResultSet();
/* 66:68 */     Vendedores_ERP vendedor = new Vendedores_ERP();
/* 67:69 */     if (rs.next())
/* 68:   */     {
/* 69:70 */       vendedor.setCodVE(rs.getString("CodVE"));
/* 70:71 */       vendedor.setNomeVE(rs.getString("NomeVE"));
/* 71:72 */       vendedor.setRegiaoVE(rs.getString("RegiaoVE"));
/* 72:73 */       vendedor.setStEI(rs.getInt("StEI"));
/* 73:   */     }
/* 74:75 */     return vendedor;
/* 75:   */   }
/* 76:   */ }


/* Location:           C:\Users\Leonardo\Desktop\INT\InterpSync.jar
 * Qualified Name:     br.com.interpsync.interdb.dao.Vendedores_INTERDBDAO
 * JD-Core Version:    0.7.0.1
 */