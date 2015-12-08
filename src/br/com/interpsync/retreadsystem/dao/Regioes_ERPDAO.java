/*  1:   */ package br.com.interpsync.retreadsystem.dao;
/*  2:   */ 
/*  3:   */ import br.com.interpsync.retreadsystem.jdbc.ConnectionFactory;
/*  4:   */ import br.com.interpsync.retreadsystem.modelo.Regioes_ERP;
/*  5:   */ import java.sql.Connection;
/*  6:   */ import java.sql.PreparedStatement;
/*  7:   */ import java.sql.ResultSet;
/*  8:   */ import java.sql.SQLException;
/*  9:   */ import java.util.ArrayList;
/* 10:   */ import java.util.List;
/* 11:   */ import java.util.logging.Level;
/* 12:   */ import java.util.logging.Logger;
/* 13:   */ 
/* 14:   */ public class Regioes_ERPDAO
/* 15:   */ {
/* 16:   */   private Connection connection;
/* 17:   */   
/* 18:   */   public Regioes_ERPDAO()
/* 19:   */   {
/* 20:   */     try
/* 21:   */     {
/* 22:27 */       this.connection = ConnectionFactory.getInstance().obterConexao();
/* 23:   */     }
/* 24:   */     catch (SQLException ex)
/* 25:   */     {
/* 26:29 */       Logger.getLogger(Regioes_ERPDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 27:   */     }
/* 28:   */     catch (ClassNotFoundException ex)
/* 29:   */     {
/* 30:31 */       Logger.getLogger(Regioes_ERPDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 31:   */     }
/* 32:   */     catch (Exception ex)
/* 33:   */     {
/* 34:33 */       Logger.getLogger(Regioes_ERPDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 35:   */     }
/* 36:   */   }
/* 37:   */   
/* 38:   */   public Connection getConnection()
/* 39:   */     throws SQLException, ClassNotFoundException, Exception
/* 40:   */   {
/* 41:41 */     if ((this.connection == null) || (this.connection.isClosed())) {
/* 42:42 */       this.connection = ConnectionFactory.getInstance().obterConexao();
/* 43:   */     }
/* 44:44 */     return this.connection;
/* 45:   */   }
/* 46:   */   
/* 47:   */   public List<Regioes_ERP> listarTodos()
/* 48:   */     throws SQLException, ClassNotFoundException, Exception
/* 49:   */   {
/* 50:51 */     String sql = "SELECT ALL * FROM REGIOES_ERP";
/* 51:52 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 52:53 */     stmt.executeQuery();
/* 53:54 */     ResultSet rs = stmt.getResultSet();
/* 54:55 */     List<Regioes_ERP> lista = new ArrayList();
/* 55:56 */     while (rs.next())
/* 56:   */     {
/* 57:57 */       Regioes_ERP regiao = new Regioes_ERP();
/* 58:58 */       regiao.setCodRE(rs.getString("CodRE"));
/* 59:59 */       regiao.setDescrRE(rs.getString("DescrRE"));
/* 60:60 */       regiao.setStEI(rs.getInt("StEI"));
/* 61:61 */       lista.add(regiao);
/* 62:   */     }
/* 63:63 */     stmt.close();
/* 64:64 */     return lista;
/* 65:   */   }
/* 66:   */   
/* 67:   */   public List<Regioes_ERP> listarNovos()
/* 68:   */     throws SQLException, ClassNotFoundException, Exception
/* 69:   */   {
/* 70:71 */     String sql = "SELECT * FROM REGIOES_ERP WHERE StEI <> 1";
/* 71:72 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 72:73 */     stmt.executeQuery();
/* 73:74 */     ResultSet rs = stmt.getResultSet();
/* 74:75 */     List<Regioes_ERP> lista = new ArrayList();
/* 75:76 */     while (rs.next())
/* 76:   */     {
/* 77:77 */       Regioes_ERP regiao = new Regioes_ERP();
/* 78:78 */       regiao.setCodRE(rs.getString("CodRE"));
/* 79:79 */       regiao.setDescrRE(rs.getString("DescrRE"));
/* 80:80 */       regiao.setStEI(rs.getInt("StEI"));
/* 81:81 */       lista.add(regiao);
/* 82:   */     }
/* 83:83 */     stmt.close();
/* 84:84 */     return lista;
/* 85:   */   }
/* 86:   */   
/* 87:   */   public void atualizar(Regioes_ERP regiao)
/* 88:   */     throws SQLException, ClassNotFoundException, Exception
/* 89:   */   {
/* 90:91 */     String sql = "UPDATE REGIOES_ERP SET DescrRE = ?, StEI = ? WHERE CodRE = ?";
/* 91:92 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 92:93 */     stmt.setString(1, regiao.getDescrRE());
/* 93:94 */     stmt.setInt(2, regiao.getStEI());
/* 94:95 */     stmt.setString(3, regiao.getCodRE());
/* 95:96 */     stmt.executeUpdate();
/* 96:97 */     stmt.close();
/* 97:   */   }
/* 98:   */ }


/* Location:           C:\Users\Leonardo\Desktop\INT\InterpSync.jar
 * Qualified Name:     br.com.interpsync.retreadsystem.dao.Regioes_ERPDAO
 * JD-Core Version:    0.7.0.1
 */