/*  1:   */ package br.com.interpsync.saci.dao;
/*  2:   */ 
/*  3:   */ import br.com.interpsync.saci.jdbc.ConnectionFactorySACI;
/*  4:   */ import br.com.interpsync.saci.modelo.Stk_SACI;
/*  5:   */ import java.sql.Connection;
/*  6:   */ import java.sql.PreparedStatement;
/*  7:   */ import java.sql.ResultSet;
/*  8:   */ import java.sql.SQLException;
/*  9:   */ import java.util.logging.Level;
/* 10:   */ import java.util.logging.Logger;
/* 11:   */ 
/* 12:   */ public class Stk_SACIDAO
/* 13:   */ {
/* 14:   */   private Connection conexao;
/* 15:   */   
/* 16:   */   public Stk_SACIDAO()
/* 17:   */   {
/* 18:   */     try
/* 19:   */     {
/* 20:25 */       this.conexao = ConnectionFactorySACI.getInstance().obterConexao();
/* 21:   */     }
/* 22:   */     catch (SQLException ex)
/* 23:   */     {
/* 24:27 */       Logger.getLogger(Stk_SACIDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 25:   */     }
/* 26:   */     catch (ClassNotFoundException ex)
/* 27:   */     {
/* 28:29 */       Logger.getLogger(Stk_SACIDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 29:   */     }
/* 30:   */     catch (Exception ex)
/* 31:   */     {
/* 32:31 */       Logger.getLogger(Stk_SACIDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 33:   */     }
/* 34:   */   }
/* 35:   */   
/* 36:   */   public Connection getConnection()
/* 37:   */     throws SQLException, ClassNotFoundException, Exception
/* 38:   */   {
/* 39:39 */     if ((this.conexao == null) || (this.conexao.isClosed())) {
/* 40:40 */       this.conexao = ConnectionFactorySACI.getInstance().obterConexao();
/* 41:   */     }
/* 42:42 */     return this.conexao;
/* 43:   */   }
/* 44:   */   
/* 45:   */   public Stk_SACI getEstoque(String codigo)
/* 46:   */     throws ClassNotFoundException, SQLException, Exception
/* 47:   */   {
/* 48:49 */     String sql = "SELECT storeno, prdno, qtty_varejo, lastchangedt FROM stk    WHERE storeno = 4 and prdno = ?";
/* 49:   */     
/* 50:51 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 51:52 */     stmt.setString(1, codigo);
/* 52:53 */     stmt.executeQuery();
/* 53:54 */     ResultSet rs = stmt.getResultSet();
/* 54:55 */     if (rs.next())
/* 55:   */     {
/* 56:   */       try
/* 57:   */       {
/* 58:57 */         rs.findColumn("storeno");
/* 59:   */       }
/* 60:   */       catch (Exception e) {}
/* 61:60 */       Stk_SACI estoque = new Stk_SACI();
/* 62:61 */       estoque.setStoreno(Long.valueOf(rs.getLong("storeno")));
/* 63:62 */       estoque.setPrdno(rs.getString("prdno"));
/* 64:63 */       estoque.setQtty_varejo(Long.valueOf(rs.getLong("qtty_varejo")));
/* 65:64 */       estoque.setLastchangedt(Long.valueOf(rs.getLong("lastchangedt")));
/* 66:65 */       stmt.close();
/* 67:66 */       return estoque;
/* 68:   */     }
/* 69:68 */     stmt.close();
/* 70:69 */     return null;
/* 71:   */   }
/* 72:   */   
/* 73:   */   public void AtualizarEstoque(Stk_SACI estoque)
/* 74:   */     throws ClassNotFoundException, SQLException, Exception
/* 75:   */   {
/* 76:75 */     String sql = "UPDATE stk SET qtty_varejo = ?, lastchangedt = ?    WHERE storeno = ? AND prdno = ?";
/* 77:   */     
/* 78:77 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 79:78 */     stmt.setLong(1, estoque.getQtty_varejo().longValue());
/* 80:79 */     stmt.setLong(2, estoque.getLastchangedt().longValue());
/* 81:80 */     stmt.setLong(3, estoque.getStoreno().longValue());
/* 82:81 */     stmt.setString(4, estoque.getPrdno());
/* 83:82 */     stmt.executeUpdate();
/* 84:83 */     stmt.close();
/* 85:   */   }
/* 86:   */ }



/* Location:           C:\Users\Leonardo\Desktop\INT\InterpSync.jar

 * Qualified Name:     br.com.interpsync.saci.dao.Stk_SACIDAO

 * JD-Core Version:    0.7.0.1

 */