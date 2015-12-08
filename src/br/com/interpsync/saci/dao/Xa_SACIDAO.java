/*  1:   */ package br.com.interpsync.saci.dao;
/*  2:   */ 
/*  3:   */ import br.com.interpsync.saci.jdbc.ConnectionFactorySACI;
/*  4:   */ import java.sql.Connection;
/*  5:   */ import java.sql.PreparedStatement;
/*  6:   */ import java.sql.ResultSet;
/*  7:   */ import java.sql.SQLException;
/*  8:   */ import java.util.logging.Level;
/*  9:   */ import java.util.logging.Logger;
/* 10:   */ 
/* 11:   */ public class Xa_SACIDAO
/* 12:   */ {
/* 13:   */   private Connection conexao;
/* 14:   */   
/* 15:   */   public Xa_SACIDAO()
/* 16:   */   {
/* 17:   */     try
/* 18:   */     {
/* 19:24 */       this.conexao = ConnectionFactorySACI.getInstance().obterConexao();
/* 20:   */     }
/* 21:   */     catch (SQLException ex)
/* 22:   */     {
/* 23:26 */       Logger.getLogger(Xa_SACIDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 24:   */     }
/* 25:   */     catch (ClassNotFoundException ex)
/* 26:   */     {
/* 27:28 */       Logger.getLogger(Xa_SACIDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 28:   */     }
/* 29:   */     catch (Exception ex)
/* 30:   */     {
/* 31:30 */       Logger.getLogger(Xa_SACIDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 32:   */     }
/* 33:   */   }
/* 34:   */   
/* 35:   */   public Connection getConnection()
/* 36:   */     throws SQLException, ClassNotFoundException, Exception
/* 37:   */   {
/* 38:38 */     if ((this.conexao == null) || (this.conexao.isClosed())) {
/* 39:39 */       this.conexao = ConnectionFactorySACI.getInstance().obterConexao();
/* 40:   */     }
/* 41:41 */     return this.conexao;
/* 42:   */   }
/* 43:   */   
/* 44:   */   public Long NovaTrans()
/* 45:   */     throws ClassNotFoundException, SQLException, Exception
/* 46:   */   {
/* 47:48 */     String sql1 = "SELECT (MAX(xano) + 1) xano FROM xa ";
/* 48:49 */     String sql2 = "INSERT INTO xa VALUES (?)";
/* 49:50 */     PreparedStatement stmt = getConnection().prepareStatement(sql1);
/* 50:51 */     ResultSet rs = stmt.executeQuery();
/* 51:52 */     if (rs.next())
/* 52:   */     {
/* 53:   */       try
/* 54:   */       {
/* 55:54 */         rs.findColumn("xano");
/* 56:   */       }
/* 57:   */       catch (Exception e) {}
/* 58:57 */       PreparedStatement stmt2 = getConnection().prepareStatement(sql2);
/* 59:58 */       stmt2.setLong(1, rs.getLong("xano"));
/* 60:59 */       stmt2.executeUpdate();
/* 61:60 */       Long saida = Long.valueOf(rs.getLong("xano"));
/* 62:61 */       stmt2.close();
/* 63:62 */       stmt.close();
/* 64:63 */       return saida;
/* 65:   */     }
/* 66:65 */     return null;
/* 67:   */   }
/* 68:   */ }


/* Location:           C:\Users\Leonardo\Desktop\INT\InterpSync.jar
 * Qualified Name:     br.com.interpsync.saci.dao.Xa_SACIDAO
 * JD-Core Version:    0.7.0.1
 */