/*   1:    */ package br.com.interpsync.retreadsystem.dao;
/*   2:    */ 
/*   3:    */ import br.com.interpsync.retreadsystem.jdbc.ConnectionFactory;
/*   4:    */ import br.com.interpsync.retreadsystem.modelo.Coxins_ERP;
/*   5:    */ import java.sql.Connection;
/*   6:    */ import java.sql.PreparedStatement;
/*   7:    */ import java.sql.ResultSet;
/*   8:    */ import java.sql.SQLException;
/*   9:    */ import java.util.ArrayList;
/*  10:    */ import java.util.List;
/*  11:    */ import java.util.logging.Level;
/*  12:    */ import java.util.logging.Logger;
/*  13:    */ 
/*  14:    */ public class Coxins_ERPDAO
/*  15:    */ {
/*  16:    */   private Connection connection;
/*  17:    */   
/*  18:    */   public Coxins_ERPDAO()
/*  19:    */   {
/*  20:    */     try
/*  21:    */     {
/*  22: 28 */       this.connection = ConnectionFactory.getInstance().obterConexao();
/*  23:    */     }
/*  24:    */     catch (SQLException ex)
/*  25:    */     {
/*  26: 30 */       Logger.getLogger(Coxins_ERPDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  27:    */     }
/*  28:    */     catch (ClassNotFoundException ex)
/*  29:    */     {
/*  30: 32 */       Logger.getLogger(Coxins_ERPDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  31:    */     }
/*  32:    */     catch (Exception ex)
/*  33:    */     {
/*  34: 34 */       Logger.getLogger(Coxins_ERPDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  35:    */     }
/*  36:    */   }
/*  37:    */   
/*  38:    */   public Connection getConnection()
/*  39:    */     throws SQLException, ClassNotFoundException, Exception
/*  40:    */   {
/*  41: 42 */     if ((this.connection == null) || (this.connection.isClosed())) {
/*  42: 43 */       this.connection = ConnectionFactory.getInstance().obterConexao();
/*  43:    */     }
/*  44: 45 */     return this.connection;
/*  45:    */   }
/*  46:    */   
/*  47:    */   public List<Coxins_ERP> listarTodos()
/*  48:    */     throws SQLException, ClassNotFoundException, Exception
/*  49:    */   {
/*  50: 51 */     String sql = "SELECT ALL  * FROM COXINS_ERP";
/*  51: 52 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/*  52: 53 */     stmt.executeQuery();
/*  53: 54 */     ResultSet rs = stmt.getResultSet();
/*  54: 55 */     List<Coxins_ERP> coxins = new ArrayList();
/*  55: 56 */     while (rs.next())
/*  56:    */     {
/*  57: 57 */       Coxins_ERP coxin = new Coxins_ERP();
/*  58: 58 */       coxin.setCodCX(rs.getString("CodCX"));
/*  59: 59 */       coxin.setDescrCX(rs.getString("DescrCX"));
/*  60: 60 */       coxin.setPesoCX(rs.getBigDecimal("PesoCX"));
/*  61: 61 */       coxin.setStei(rs.getInt("Stei"));
/*  62: 62 */       coxins.add(coxin);
/*  63:    */     }
/*  64: 64 */     stmt.close();
/*  65: 65 */     return coxins;
/*  66:    */   }
/*  67:    */   
/*  68:    */   public List<Coxins_ERP> listarNovos()
/*  69:    */     throws SQLException, ClassNotFoundException, Exception
/*  70:    */   {
/*  71: 72 */     String sql = "SELECT * FROM COXINS_ERP WHERE Stei <> 1";
/*  72: 73 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/*  73: 74 */     stmt.executeQuery();
/*  74: 75 */     ResultSet rs = stmt.getResultSet();
/*  75: 76 */     List<Coxins_ERP> coxins = new ArrayList();
/*  76: 77 */     while (rs.next())
/*  77:    */     {
/*  78: 78 */       Coxins_ERP coxin = new Coxins_ERP();
/*  79: 79 */       coxin.setCodCX(rs.getString("CodCX"));
/*  80: 80 */       coxin.setDescrCX(rs.getString("DescrCX"));
/*  81: 81 */       coxin.setPesoCX(rs.getBigDecimal("PesoCX"));
/*  82: 82 */       coxin.setStei(rs.getInt("Stei"));
/*  83: 83 */       coxins.add(coxin);
/*  84:    */     }
/*  85: 85 */     stmt.close();
/*  86: 86 */     return coxins;
/*  87:    */   }
/*  88:    */   
/*  89:    */   public void atualizar(Coxins_ERP coxin)
/*  90:    */     throws SQLException, ClassNotFoundException, Exception
/*  91:    */   {
/*  92: 93 */     String sql = "UPDATE COXINS_ERP SET DescrCX = ?, PesoCX = ?, Stei = ?  WHERE CodCX = ?";
/*  93:    */     
/*  94: 95 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/*  95: 96 */     stmt.setString(1, coxin.getDescrCX());
/*  96: 97 */     stmt.setBigDecimal(2, coxin.getPesoCX());
/*  97: 98 */     stmt.setInt(3, coxin.getStei());
/*  98: 99 */     stmt.setString(4, coxin.getCodCX());
/*  99:100 */     stmt.executeUpdate();
/* 100:101 */     stmt.close();
/* 101:    */   }
/* 102:    */ }


/* Location:           C:\Users\Leonardo\Desktop\INT\InterpSync.jar
 * Qualified Name:     br.com.interpsync.retreadsystem.dao.Coxins_ERPDAO
 * JD-Core Version:    0.7.0.1
 */