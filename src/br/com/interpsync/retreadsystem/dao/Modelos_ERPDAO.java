/*   1:    */ package br.com.interpsync.retreadsystem.dao;
/*   2:    */ 
/*   3:    */ import br.com.interpsync.retreadsystem.jdbc.ConnectionFactory;
/*   4:    */ import br.com.interpsync.retreadsystem.modelo.Modelos_ERP;
/*   5:    */ import java.sql.Connection;
/*   6:    */ import java.sql.PreparedStatement;
/*   7:    */ import java.sql.ResultSet;
/*   8:    */ import java.sql.SQLException;
/*   9:    */ import java.util.ArrayList;
/*  10:    */ import java.util.List;
/*  11:    */ import java.util.logging.Level;
/*  12:    */ import java.util.logging.Logger;
/*  13:    */ 
/*  14:    */ public class Modelos_ERPDAO
/*  15:    */ {
/*  16:    */   private Connection connection;
/*  17:    */   
/*  18:    */   public Modelos_ERPDAO()
/*  19:    */   {
/*  20:    */     try
/*  21:    */     {
/*  22: 27 */       this.connection = ConnectionFactory.getInstance().obterConexao();
/*  23:    */     }
/*  24:    */     catch (SQLException ex)
/*  25:    */     {
/*  26: 29 */       Logger.getLogger(Modelos_ERPDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  27:    */     }
/*  28:    */     catch (ClassNotFoundException ex)
/*  29:    */     {
/*  30: 31 */       Logger.getLogger(Modelos_ERPDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  31:    */     }
/*  32:    */     catch (Exception ex)
/*  33:    */     {
/*  34: 33 */       Logger.getLogger(Modelos_ERPDAO.class.getName()).log(Level.SEVERE, null, ex);
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
/*  47:    */   public List<Modelos_ERP> listarTodos()
/*  48:    */     throws SQLException, ClassNotFoundException, Exception
/*  49:    */   {
/*  50: 51 */     String sql = "SELECT ALL * FROM MODELOS_ERP";
/*  51: 52 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/*  52: 53 */     stmt.executeQuery();
/*  53: 54 */     ResultSet rs = stmt.getResultSet();
/*  54: 55 */     List<Modelos_ERP> modelos = new ArrayList();
/*  55: 56 */     while (rs.next())
/*  56:    */     {
/*  57: 57 */       Modelos_ERP modelo = new Modelos_ERP();
/*  58: 58 */       modelo.setCodMO(rs.getString("CodMO"));
/*  59: 59 */       modelo.setDescrMO(rs.getString("DescrMO"));
/*  60: 60 */       modelo.setMarcaMO(rs.getString("MarcaMO"));
/*  61: 61 */       modelo.setVocMO(rs.getString("VocMO"));
/*  62: 62 */       modelo.setStEI(rs.getInt("StEI"));
/*  63: 63 */       modelos.add(modelo);
/*  64:    */     }
/*  65: 65 */     stmt.close();
/*  66: 66 */     return modelos;
/*  67:    */   }
/*  68:    */   
/*  69:    */   public List<Modelos_ERP> listarNovos()
/*  70:    */     throws SQLException, ClassNotFoundException, Exception
/*  71:    */   {
/*  72: 73 */     String sql = "SELECT * FROM MODELOS_ERP WHERE StEI <> 1";
/*  73: 74 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/*  74: 75 */     stmt.executeQuery();
/*  75: 76 */     ResultSet rs = stmt.getResultSet();
/*  76: 77 */     List<Modelos_ERP> modelos = new ArrayList();
/*  77: 78 */     while (rs.next())
/*  78:    */     {
/*  79: 79 */       Modelos_ERP modelo = new Modelos_ERP();
/*  80: 80 */       modelo.setCodMO(rs.getString("CodMO"));
/*  81: 81 */       modelo.setDescrMO(rs.getString("DescrMO"));
/*  82: 82 */       modelo.setMarcaMO(rs.getString("MarcaMO"));
/*  83: 83 */       modelo.setVocMO(rs.getString("VocMO"));
/*  84: 84 */       modelo.setStEI(rs.getInt("StEI"));
/*  85: 85 */       modelos.add(modelo);
/*  86:    */     }
/*  87: 87 */     stmt.close();
/*  88: 88 */     return modelos;
/*  89:    */   }
/*  90:    */   
/*  91:    */   public void atualizar(Modelos_ERP modelos)
/*  92:    */     throws ClassNotFoundException, SQLException, Exception
/*  93:    */   {
/*  94: 95 */     String sql = "UPDATE MODELOS_ERP SET DescrMO = ?, MarcaMO = ?, VocMO = ?, StEI = ? WHERE CodMO = ?";
/*  95: 96 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/*  96: 97 */     stmt.setString(1, modelos.getDescrMO());
/*  97: 98 */     stmt.setString(2, modelos.getMarcaMO());
/*  98: 99 */     stmt.setString(3, modelos.getVocMO());
/*  99:100 */     stmt.setInt(4, modelos.getStEI());
/* 100:101 */     stmt.setString(5, modelos.getCodMO());
/* 101:102 */     stmt.executeUpdate();
/* 102:103 */     stmt.close();
/* 103:    */   }
/* 104:    */ }


/* Location:           C:\Users\Leonardo\Desktop\INT\InterpSync.jar
 * Qualified Name:     br.com.interpsync.retreadsystem.dao.Modelos_ERPDAO
 * JD-Core Version:    0.7.0.1
 */