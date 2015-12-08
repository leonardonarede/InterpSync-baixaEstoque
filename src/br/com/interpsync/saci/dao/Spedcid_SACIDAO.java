/*  1:   */ package br.com.interpsync.saci.dao;
/*  2:   */ 
/*  3:   */ import br.com.interpsync.saci.jdbc.ConnectionFactorySACI;
/*  4:   */ import br.com.interpsync.saci.modelo.Spedcid_SACI;
/*  5:   */ import java.sql.Connection;
/*  6:   */ import java.sql.PreparedStatement;
/*  7:   */ import java.sql.ResultSet;
/*  8:   */ import java.sql.SQLException;
/*  9:   */ import java.util.logging.Level;
/* 10:   */ import java.util.logging.Logger;
/* 11:   */ 
/* 12:   */ public class Spedcid_SACIDAO
/* 13:   */ {
/* 14:   */   private Connection conexao;
/* 15:   */   
/* 16:   */   public Spedcid_SACIDAO()
/* 17:   */   {
/* 18:   */     try
/* 19:   */     {
/* 20:25 */       this.conexao = ConnectionFactorySACI.getInstance().obterConexao();
/* 21:   */     }
/* 22:   */     catch (SQLException ex)
/* 23:   */     {
/* 24:27 */       Logger.getLogger(Prd_SACIDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 25:   */     }
/* 26:   */     catch (ClassNotFoundException ex)
/* 27:   */     {
/* 28:29 */       Logger.getLogger(Prd_SACIDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 29:   */     }
/* 30:   */     catch (Exception ex)
/* 31:   */     {
/* 32:31 */       Logger.getLogger(Prd_SACIDAO.class.getName()).log(Level.SEVERE, null, ex);
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
/* 45:   */   public Spedcid_SACI localizar(String cidade, String estado)
/* 46:   */     throws ClassNotFoundException, SQLException, Exception
/* 47:   */   {
/* 48:49 */     String sql = "SELECT * FROM spedcid    WHERE name LIKE ? AND state LIKE ? LIMIT 1";
/* 49:   */     
/* 50:51 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 51:52 */     stmt.setString(1, cidade);
/* 52:53 */     stmt.setString(2, estado);
/* 53:54 */     stmt.executeQuery();
/* 54:55 */     ResultSet rs = stmt.getResultSet();
/* 55:56 */     Spedcid_SACI cid = new Spedcid_SACI();
/* 56:57 */     if (rs.next())
/* 57:   */     {
/* 58:58 */       cid.setNo(Integer.valueOf(rs.getInt("no")));
/* 59:59 */       cid.setName(rs.getString("name"));
/* 60:60 */       cid.setState(rs.getString("state"));
/* 61:61 */       cid.setAuxShort1(Integer.valueOf(rs.getInt("auxShort1")));
/* 62:   */     }
/* 63:63 */     return cid;
/* 64:   */   }
/* 65:   */ }


/* Location:           C:\Users\Leonardo\Desktop\INT\InterpSync.jar
 * Qualified Name:     br.com.interpsync.saci.dao.Spedcid_SACIDAO
 * JD-Core Version:    0.7.0.1
 */