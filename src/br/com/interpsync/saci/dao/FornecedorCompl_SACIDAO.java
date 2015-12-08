/*  1:   */ package br.com.interpsync.saci.dao;
/*  2:   */ 
/*  3:   */ import br.com.interpsync.saci.jdbc.ConnectionFactorySACI;
/*  4:   */ import br.com.interpsync.saci.modelo.FornecedorCompl_SACI;
/*  5:   */ import java.sql.Connection;
/*  6:   */ import java.sql.PreparedStatement;
/*  7:   */ import java.sql.SQLException;
/*  8:   */ import java.util.logging.Level;
/*  9:   */ import java.util.logging.Logger;
/* 10:   */ 
/* 11:   */ public class FornecedorCompl_SACIDAO
/* 12:   */ {
/* 13:   */   private Connection conexao;
/* 14:   */   
/* 15:   */   public FornecedorCompl_SACIDAO()
/* 16:   */   {
/* 17:   */     try
/* 18:   */     {
/* 19:24 */       this.conexao = ConnectionFactorySACI.getInstance().obterConexao();
/* 20:   */     }
/* 21:   */     catch (SQLException ex)
/* 22:   */     {
/* 23:26 */       Logger.getLogger(Prd_SACIDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 24:   */     }
/* 25:   */     catch (ClassNotFoundException ex)
/* 26:   */     {
/* 27:28 */       Logger.getLogger(Prd_SACIDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 28:   */     }
/* 29:   */     catch (Exception ex)
/* 30:   */     {
/* 31:30 */       Logger.getLogger(Prd_SACIDAO.class.getName()).log(Level.SEVERE, null, ex);
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
/* 44:   */   public void inserir(FornecedorCompl_SACI compl)
/* 45:   */     throws ClassNotFoundException, Exception
/* 46:   */   {
/* 47:47 */     String sql = "INSERT INTO vend2 (vendno, pais, auxLong1) VALUES (?, ?, ?) ";
/* 48:48 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 49:49 */     stmt.setInt(1, compl.getVendno().intValue());
/* 50:50 */     stmt.setInt(2, compl.getPais().intValue());
/* 51:51 */     stmt.setInt(3, compl.getAuxLong1().intValue());
/* 52:52 */     stmt.executeUpdate();
/* 53:53 */     stmt.close();
/* 54:   */   }
/* 55:   */ }


/* Location:           C:\Users\Leonardo\Desktop\INT\InterpSync.jar
 * Qualified Name:     br.com.interpsync.saci.dao.FornecedorCompl_SACIDAO
 * JD-Core Version:    0.7.0.1
 */