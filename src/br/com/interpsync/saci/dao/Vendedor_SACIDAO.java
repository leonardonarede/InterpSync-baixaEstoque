/*  1:   */ package br.com.interpsync.saci.dao;
/*  2:   */ 
/*  3:   */ import br.com.interpsync.saci.jdbc.ConnectionFactorySACI;
/*  4:   */ import br.com.interpsync.saci.modelo.Vendedor_SACI;
/*  5:   */ import java.sql.Connection;
/*  6:   */ import java.sql.PreparedStatement;
/*  7:   */ import java.sql.ResultSet;
/*  8:   */ import java.sql.SQLException;
/*  9:   */ import java.util.ArrayList;
/* 10:   */ import java.util.List;
/* 11:   */ import java.util.logging.Level;
/* 12:   */ import java.util.logging.Logger;
/* 13:   */ 
/* 14:   */ public class Vendedor_SACIDAO
/* 15:   */ {
/* 16:   */   private Connection conexao;
/* 17:   */   
/* 18:   */   public Vendedor_SACIDAO()
/* 19:   */   {
/* 20:   */     try
/* 21:   */     {
/* 22:27 */       this.conexao = ConnectionFactorySACI.getInstance().obterConexao();
/* 23:   */     }
/* 24:   */     catch (SQLException ex)
/* 25:   */     {
/* 26:29 */       Logger.getLogger(Cliente_SACIDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 27:   */     }
/* 28:   */     catch (ClassNotFoundException ex)
/* 29:   */     {
/* 30:31 */       Logger.getLogger(Cliente_SACIDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 31:   */     }
/* 32:   */     catch (Exception ex)
/* 33:   */     {
/* 34:33 */       Logger.getLogger(Cliente_SACIDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 35:   */     }
/* 36:   */   }
/* 37:   */   
/* 38:   */   public Connection getConnection()
/* 39:   */     throws SQLException, ClassNotFoundException, Exception
/* 40:   */   {
/* 41:41 */     if ((this.conexao == null) || (this.conexao.isClosed())) {
/* 42:42 */       this.conexao = ConnectionFactorySACI.getInstance().obterConexao();
/* 43:   */     }
/* 44:44 */     return this.conexao;
/* 45:   */   }
/* 46:   */   
/* 47:   */   public List<Vendedor_SACI> listar()
/* 48:   */     throws SQLException, ClassNotFoundException, Exception
/* 49:   */   {
/* 50:50 */     String sql = "SELECT * FROM emp    WHERE emp.funcao = 2 AND emp.status = 1 ";
/* 51:   */     
/* 52:52 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 53:53 */     stmt.executeQuery();
/* 54:54 */     ResultSet rs = stmt.getResultSet();
/* 55:55 */     List<Vendedor_SACI> vendedores = new ArrayList();
/* 56:56 */     while (rs.next())
/* 57:   */     {
/* 58:57 */       Vendedor_SACI vendedor = new Vendedor_SACI();
/* 59:58 */       vendedor.setNo(Integer.valueOf(rs.getInt("no")));
/* 60:59 */       vendedor.setNome(rs.getString("name"));
/* 61:60 */       vendedor.setStoreno(rs.getInt("storeno"));
/* 62:61 */       vendedores.add(vendedor);
/* 63:   */     }
/* 64:63 */     stmt.close();
/* 65:64 */     return vendedores;
/* 66:   */   }
/* 67:   */   
/* 68:   */   public Vendedor_SACI findbyid(Integer id)
/* 69:   */     throws SQLException, ClassNotFoundException, Exception
/* 70:   */   {
/* 71:71 */     String sql = "SELECT * FROM emp WHERE emp.no = ?";
/* 72:72 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 73:73 */     stmt.setInt(1, id.intValue());
/* 74:74 */     stmt.executeQuery();
/* 75:75 */     ResultSet rs = stmt.getResultSet();
/* 76:76 */     if (rs.next())
/* 77:   */     {
/* 78:   */       try
/* 79:   */       {
/* 80:78 */         rs.getLong("no");
/* 81:   */       }
/* 82:   */       catch (Exception e) {}
/* 83:81 */       Vendedor_SACI vendedor = new Vendedor_SACI();
/* 84:82 */       vendedor.setNo(Integer.valueOf(rs.getInt("no")));
/* 85:83 */       vendedor.setNome(rs.getString("name"));
/* 86:84 */       vendedor.setStoreno(rs.getInt("storeno"));
/* 87:85 */       stmt.close();
/* 88:86 */       return vendedor;
/* 89:   */     }
/* 90:88 */     stmt.close();
/* 91:89 */     return null;
/* 92:   */   }
/* 93:   */ }


/* Location:           C:\Users\Leonardo\Desktop\INT\InterpSync.jar
 * Qualified Name:     br.com.interpsync.saci.dao.Vendedor_SACIDAO
 * JD-Core Version:    0.7.0.1
 */