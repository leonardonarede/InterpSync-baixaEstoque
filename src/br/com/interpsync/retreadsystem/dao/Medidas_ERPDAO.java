/*   1:    */ package br.com.interpsync.retreadsystem.dao;
/*   2:    */ 
/*   3:    */ import br.com.interpsync.retreadsystem.jdbc.ConnectionFactory;
/*   4:    */ import br.com.interpsync.retreadsystem.modelo.Medidas_ERP;
/*   5:    */ import java.sql.Connection;
/*   6:    */ import java.sql.PreparedStatement;
/*   7:    */ import java.sql.ResultSet;
/*   8:    */ import java.sql.SQLException;
/*   9:    */ import java.util.ArrayList;
/*  10:    */ import java.util.List;
/*  11:    */ import java.util.logging.Level;
/*  12:    */ import java.util.logging.Logger;
/*  13:    */ 
/*  14:    */ public class Medidas_ERPDAO
/*  15:    */ {
/*  16:    */   private Connection connection;
/*  17:    */   
/*  18:    */   public Medidas_ERPDAO()
/*  19:    */   {
/*  20:    */     try
/*  21:    */     {
/*  22: 27 */       this.connection = ConnectionFactory.getInstance().obterConexao();
/*  23:    */     }
/*  24:    */     catch (SQLException ex)
/*  25:    */     {
/*  26: 29 */       Logger.getLogger(Medidas_ERPDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  27:    */     }
/*  28:    */     catch (ClassNotFoundException ex)
/*  29:    */     {
/*  30: 31 */       Logger.getLogger(Medidas_ERPDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  31:    */     }
/*  32:    */     catch (Exception ex)
/*  33:    */     {
/*  34: 33 */       Logger.getLogger(Medidas_ERPDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  35:    */     }
/*  36:    */   }
/*  37:    */   
/*  38:    */   public Connection getConnection()
/*  39:    */     throws SQLException, ClassNotFoundException, Exception
/*  40:    */   {
/*  41: 41 */     if ((this.connection == null) || (this.connection.isClosed())) {
/*  42: 42 */       this.connection = ConnectionFactory.getInstance().obterConexao();
/*  43:    */     }
/*  44: 44 */     return this.connection;
/*  45:    */   }
/*  46:    */   
/*  47:    */   public List<Medidas_ERP> listarTodos()
/*  48:    */     throws SQLException, ClassNotFoundException, Exception
/*  49:    */   {
/*  50: 51 */     String sql = "SELECT ALL * FROM MEDIDAS_ERP";
/*  51: 52 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/*  52: 53 */     stmt.executeQuery();
/*  53: 54 */     ResultSet rs = stmt.getResultSet();
/*  54: 55 */     List<Medidas_ERP> medidas = new ArrayList();
/*  55: 56 */     while (rs.next())
/*  56:    */     {
/*  57: 57 */       Medidas_ERP medida = new Medidas_ERP();
/*  58: 58 */       medida.setCodME(rs.getString("CodME"));
/*  59: 59 */       medida.setDescrME(rs.getString("DescrME"));
/*  60: 60 */       medida.setTipoME(rs.getString("TipoME"));
/*  61: 61 */       medida.setStEI(rs.getInt("StEI"));
/*  62: 62 */       medidas.add(medida);
/*  63:    */     }
/*  64: 64 */     stmt.close();
/*  65: 65 */     return medidas;
/*  66:    */   }
/*  67:    */   
/*  68:    */   public List<Medidas_ERP> listarNovos()
/*  69:    */     throws SQLException, ClassNotFoundException, Exception
/*  70:    */   {
/*  71: 72 */     String sql = "SELECT * FROM MEDIDAS_ERP WHERE StEI <> 1";
/*  72: 73 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/*  73: 74 */     stmt.executeQuery();
/*  74: 75 */     ResultSet rs = stmt.getResultSet();
/*  75: 76 */     List<Medidas_ERP> medidas = new ArrayList();
/*  76: 77 */     while (rs.next())
/*  77:    */     {
/*  78: 78 */       Medidas_ERP medida = new Medidas_ERP();
/*  79: 79 */       medida.setCodME(rs.getString("CodME"));
/*  80: 80 */       medida.setDescrME(rs.getString("DescrME"));
/*  81: 81 */       medida.setTipoME(rs.getString("TipoME"));
/*  82: 82 */       medida.setStEI(rs.getInt("StEI"));
/*  83: 83 */       medidas.add(medida);
/*  84:    */     }
/*  85: 85 */     stmt.close();
/*  86: 86 */     return medidas;
/*  87:    */   }
/*  88:    */   
/*  89:    */   public void atualizar(Medidas_ERP medida)
/*  90:    */     throws ClassNotFoundException, SQLException, Exception
/*  91:    */   {
/*  92: 93 */     String sql = "UPDATE MEDIDAS_ERP SET DescrME = ?, TipoME = ?, StEI = ? WHERE CodME = ?";
/*  93: 94 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/*  94: 95 */     stmt.setString(1, medida.getDescrME());
/*  95: 96 */     stmt.setString(2, medida.getTipoME());
/*  96: 97 */     stmt.setInt(3, medida.getStEI());
/*  97: 98 */     stmt.setString(4, medida.getCodME());
/*  98: 99 */     stmt.executeUpdate();
/*  99:100 */     stmt.close();
/* 100:    */   }
/* 101:    */ }


/* Location:           C:\Users\Leonardo\Desktop\INT\InterpSync.jar
 * Qualified Name:     br.com.interpsync.retreadsystem.dao.Medidas_ERPDAO
 * JD-Core Version:    0.7.0.1
 */