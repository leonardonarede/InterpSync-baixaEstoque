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
/* 11:   */ public class Prd_SACIDAO
/* 12:   */ {
/* 13:   */   private Connection conexao;
/* 14:   */   
/* 15:   */   public Prd_SACIDAO()
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
/* 44:   */   public String localizarPorCampo(String tipo, String codigotipo)
/* 45:   */     throws ClassNotFoundException, SQLException, Exception
/* 46:   */   {
/* 47:48 */     String sql = "SELECT prd.no AS Produto FROM prd WHERE free_fld1 = ? AND prd.groupno IN (800000,330000)";
/* 48:   */     
/* 49:50 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 50:51 */     stmt.setString(1, tipo + '/' + codigotipo);
/* 51:52 */     ResultSet rs = stmt.executeQuery();
/* 52:53 */     if (rs.next())
/* 53:   */     {
/* 54:   */       try
/* 55:   */       {
/* 56:55 */         rs.findColumn("Produto");
/* 57:   */       }
/* 58:   */       catch (Exception e) {}
/* 59:58 */       String saida = rs.getString("Produto");
/* 60:59 */       stmt.close();
/* 61:60 */       return saida;
/* 62:   */     }
/* 63:62 */     stmt.close();
/* 64:63 */     return null;
/* 65:   */   }
/* 66:   */   
/* 67:   */   public String localizarCarcaca(String medida)
/* 68:   */     throws ClassNotFoundException, SQLException, Exception
/* 69:   */   {
/* 70:70 */     String sql = "SELECT prd.no AS Produto FROM prd WHERE (free_fld1 = ? OR free_fld2 = ?)    AND (prd.name LIKE 'CARCACA%') ";
/* 71:   */     
/* 72:72 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 73:73 */     stmt.setString(1, medida);
/* 74:74 */     stmt.setString(2, medida);
/* 75:75 */     ResultSet rs = stmt.executeQuery();
/* 76:76 */     if (rs.next())
/* 77:   */     {
/* 78:   */       try
/* 79:   */       {
/* 80:78 */         rs.findColumn("Produto");
/* 81:   */       }
/* 82:   */       catch (Exception e) {}
/* 83:81 */       String saida = rs.getString("Produto");
/* 84:82 */       stmt.close();
/* 85:83 */       return saida;
/* 86:   */     }
/* 87:85 */     stmt.close();
/* 88:86 */     return null;
/* 89:   */   }
/* 90:   */ }



/* Location:           C:\Users\Leonardo\Desktop\INT\InterpSync.jar

 * Qualified Name:     br.com.interpsync.saci.dao.Prd_SACIDAO

 * JD-Core Version:    0.7.0.1

 */