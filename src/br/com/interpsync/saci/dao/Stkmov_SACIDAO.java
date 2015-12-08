/*  1:   */ package br.com.interpsync.saci.dao;
/*  2:   */ 
/*  3:   */ import br.com.interpsync.saci.jdbc.ConnectionFactorySACI;
/*  4:   */ import br.com.interpsync.saci.modelo.Stkmov_SACI;
/*  5:   */ import java.sql.Connection;
/*  6:   */ import java.sql.PreparedStatement;
/*  7:   */ import java.sql.SQLException;
/*  8:   */ import java.util.logging.Level;
/*  9:   */ import java.util.logging.Logger;
/* 10:   */ 
/* 11:   */ public class Stkmov_SACIDAO
/* 12:   */ {
/* 13:   */   private Connection conexao;
/* 14:   */   
/* 15:   */   public Stkmov_SACIDAO()
/* 16:   */   {
/* 17:   */     try
/* 18:   */     {
/* 19:24 */       this.conexao = ConnectionFactorySACI.getInstance().obterConexao();
/* 20:   */     }
/* 21:   */     catch (SQLException ex)
/* 22:   */     {
/* 23:26 */       Logger.getLogger(Stkmov_SACIDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 24:   */     }
/* 25:   */     catch (ClassNotFoundException ex)
/* 26:   */     {
/* 27:28 */       Logger.getLogger(Stkmov_SACIDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 28:   */     }
/* 29:   */     catch (Exception ex)
/* 30:   */     {
/* 31:30 */       Logger.getLogger(Stkmov_SACIDAO.class.getName()).log(Level.SEVERE, null, ex);
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
/* 44:   */   public void inserir(Stkmov_SACI movimento)
/* 45:   */     throws ClassNotFoundException, SQLException, Exception
/* 46:   */   {
/* 47:48 */     String sql = "INSERT INTO stkmov (xano, storeno, prdno, qtty, date, remarks, cm_fiscal, cm_real, bits)    VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
/* 48:   */     
/* 49:50 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 50:51 */     stmt.setLong(1, movimento.getXano().longValue());
/* 51:52 */     stmt.setInt(2, movimento.getStoreno().intValue());
/* 52:53 */     stmt.setString(3, movimento.getPrdno());
/* 53:54 */     stmt.setLong(4, movimento.getQtty().longValue());
/* 54:55 */     stmt.setLong(5, movimento.getData().longValue());
/* 55:56 */     stmt.setString(6, movimento.getRemarks());
/* 56:57 */     stmt.setLong(7, movimento.getCm_fiscal().longValue());
/* 57:58 */     stmt.setLong(8, movimento.getCm_real().longValue());
/* 58:59 */     stmt.setInt(9, movimento.getBits().intValue());
/* 59:60 */     stmt.executeUpdate();
/* 60:61 */     stmt.close();
/* 61:   */   }
/* 62:   */ }


/* Location:           C:\Users\Leonardo\Desktop\INT\InterpSync.jar
 * Qualified Name:     br.com.interpsync.saci.dao.Stkmov_SACIDAO
 * JD-Core Version:    0.7.0.1
 */