/*  1:   */ package br.com.interpsync.interdb.dao;
/*  2:   */ 
/*  3:   */ import br.com.interpsync.interdb.jdbc.ConnectionFactoryInterDB;
/*  4:   */ import br.com.interpsync.retreadsystem.modelo.Regioes_ERP;
/*  5:   */ import java.sql.Connection;
/*  6:   */ import java.sql.PreparedStatement;
/*  7:   */ import java.sql.ResultSet;
/*  8:   */ import java.sql.SQLException;
/*  9:   */ import java.util.logging.Level;
/* 10:   */ import java.util.logging.Logger;
/* 11:   */ 
/* 12:   */ public class Regioes_INTERDBDAO
/* 13:   */ {
/* 14:   */   private Connection connection;
/* 15:   */   
/* 16:   */   public Regioes_INTERDBDAO()
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
/* 45:   */   public void inserir(Regioes_ERP regiao)
/* 46:   */     throws SQLException, ClassNotFoundException, Exception
/* 47:   */   {
/* 48:49 */     String sql = "INSERT INTO REGIOES_ERP (CodRE,DescrRE,StEI) VALUES (?,?,?)";
/* 49:   */     
/* 50:51 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 51:52 */     stmt.setString(1, regiao.getCodRE());
/* 52:53 */     stmt.setString(2, regiao.getDescrRE());
/* 53:54 */     stmt.setInt(3, regiao.getStEI());
/* 54:55 */     stmt.executeUpdate();
/* 55:56 */     stmt.close();
/* 56:   */   }
/* 57:   */   
/* 58:   */   public void atualizar(Regioes_ERP regiao)
/* 59:   */     throws ClassNotFoundException, SQLException, Exception
/* 60:   */   {
/* 61:63 */     String sql = "UPDATE REGIOES_ERP SET DescrRE = ?, StEI = ? WHERE CodRE = ?";
/* 62:64 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 63:65 */     stmt.setString(1, regiao.getDescrRE());
/* 64:66 */     stmt.setInt(2, regiao.getStEI());
/* 65:67 */     stmt.setString(3, regiao.getCodRE());
/* 66:68 */     stmt.executeUpdate();
/* 67:69 */     stmt.close();
/* 68:   */   }
/* 69:   */   
/* 70:   */   public Regioes_ERP localizarPorID(String id)
/* 71:   */     throws ClassNotFoundException, SQLException, Exception
/* 72:   */   {
/* 73:76 */     String sql = "SELECT CodRE, DescrRE, StEI FROM REGIOES_ERP WHERE CodRE = ?";
/* 74:77 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 75:78 */     stmt.setString(1, id);
/* 76:79 */     stmt.executeQuery();
/* 77:80 */     ResultSet rs = stmt.getResultSet();
/* 78:81 */     Regioes_ERP regioes = new Regioes_ERP();
/* 79:82 */     if (rs.next())
/* 80:   */     {
/* 81:83 */       regioes.setCodRE(rs.getString("CodRE"));
/* 82:84 */       regioes.setDescrRE(rs.getString("DescrRE"));
/* 83:85 */       regioes.setStEI(rs.getInt("StEI"));
/* 84:   */     }
/* 85:87 */     stmt.close();
/* 86:88 */     return regioes;
/* 87:   */   }
/* 88:   */ }


/* Location:           C:\Users\Leonardo\Desktop\INT\InterpSync.jar
 * Qualified Name:     br.com.interpsync.interdb.dao.Regioes_INTERDBDAO
 * JD-Core Version:    0.7.0.1
 */