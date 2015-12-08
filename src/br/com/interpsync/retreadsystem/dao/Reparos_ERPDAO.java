/*  1:   */ package br.com.interpsync.retreadsystem.dao;
/*  2:   */ 
/*  3:   */ import br.com.interpsync.retreadsystem.jdbc.ConnectionFactory;
/*  4:   */ import br.com.interpsync.retreadsystem.modelo.Reparos_ERP;
/*  5:   */ import java.sql.Connection;
/*  6:   */ import java.sql.PreparedStatement;
/*  7:   */ import java.sql.ResultSet;
/*  8:   */ import java.sql.SQLException;
/*  9:   */ import java.util.ArrayList;
/* 10:   */ import java.util.List;
/* 11:   */ import java.util.logging.Level;
/* 12:   */ import java.util.logging.Logger;
/* 13:   */ 
/* 14:   */ public class Reparos_ERPDAO
/* 15:   */ {
/* 16:   */   private Connection connection;
/* 17:   */   
/* 18:   */   public Reparos_ERPDAO()
/* 19:   */   {
/* 20:   */     try
/* 21:   */     {
/* 22:27 */       this.connection = ConnectionFactory.getInstance().obterConexao();
/* 23:   */     }
/* 24:   */     catch (SQLException ex)
/* 25:   */     {
/* 26:29 */       Logger.getLogger(Reparos_ERPDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 27:   */     }
/* 28:   */     catch (ClassNotFoundException ex)
/* 29:   */     {
/* 30:31 */       Logger.getLogger(Reparos_ERPDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 31:   */     }
/* 32:   */     catch (Exception ex)
/* 33:   */     {
/* 34:33 */       Logger.getLogger(Reparos_ERPDAO.class.getName()).log(Level.SEVERE, null, ex);
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
/* 47:   */   public List<Reparos_ERP> listarNovos()
/* 48:   */     throws SQLException, ClassNotFoundException, Exception
/* 49:   */   {
/* 50:51 */     String sql = "SELECT * FROM REPAROS_ERP WHERE StEI <> 1";
/* 51:52 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 52:53 */     stmt.executeQuery();
/* 53:54 */     ResultSet rs = stmt.getResultSet();
/* 54:55 */     List<Reparos_ERP> reparos = new ArrayList();
/* 55:56 */     while (rs.next())
/* 56:   */     {
/* 57:57 */       Reparos_ERP reparo = new Reparos_ERP();
/* 58:58 */       reparo.setCodRP(rs.getString("CodRP"));
/* 59:59 */       reparo.setDescrRP(rs.getString("DescrRP"));
/* 60:60 */       reparo.setStei(rs.getInt("Stei"));
/* 61:61 */       reparos.add(reparo);
/* 62:   */     }
/* 63:63 */     stmt.close();
/* 64:64 */     return reparos;
/* 65:   */   }
/* 66:   */   
/* 67:   */   public List<Reparos_ERP> listarTodos()
/* 68:   */     throws SQLException, ClassNotFoundException, Exception
/* 69:   */   {
/* 70:71 */     String sql = "SELECT ALL * FROM REPAROS_ERP";
/* 71:72 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 72:73 */     stmt.executeQuery();
/* 73:74 */     ResultSet rs = stmt.getResultSet();
/* 74:75 */     List<Reparos_ERP> reparos = new ArrayList();
/* 75:76 */     while (rs.next())
/* 76:   */     {
/* 77:77 */       Reparos_ERP reparo = new Reparos_ERP();
/* 78:78 */       reparo.setCodRP(rs.getString("CodRP"));
/* 79:79 */       reparo.setDescrRP(rs.getString("DescrRP"));
/* 80:80 */       reparo.setStei(rs.getInt("Stei"));
/* 81:81 */       reparos.add(reparo);
/* 82:   */     }
/* 83:83 */     stmt.close();
/* 84:84 */     return reparos;
/* 85:   */   }
/* 86:   */   
/* 87:   */   public void atualizar(Reparos_ERP reparo)
/* 88:   */     throws ClassNotFoundException, SQLException, Exception
/* 89:   */   {
/* 90:91 */     String sql = "UPDATE REPAROS_ERP SET DescrRP = ?, Stei = ? WHERE CodRP = ?";
/* 91:92 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 92:93 */     stmt.setString(1, reparo.getDescrRP());
/* 93:94 */     stmt.setInt(2, reparo.getStei());
/* 94:95 */     stmt.setString(3, reparo.getCodRP());
/* 95:96 */     stmt.executeUpdate();
/* 96:97 */     stmt.close();
/* 97:   */   }
/* 98:   */ }


/* Location:           C:\Users\Leonardo\Desktop\INT\InterpSync.jar
 * Qualified Name:     br.com.interpsync.retreadsystem.dao.Reparos_ERPDAO
 * JD-Core Version:    0.7.0.1
 */