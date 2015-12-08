/*   1:    */ package br.com.interpsync.retreadsystem.dao;
/*   2:    */ 
/*   3:    */ import br.com.interpsync.retreadsystem.jdbc.ConnectionFactory;
/*   4:    */ import br.com.interpsync.retreadsystem.modelo.Desreforma_ERP;
/*   5:    */ import java.sql.Connection;
/*   6:    */ import java.sql.PreparedStatement;
/*   7:    */ import java.sql.ResultSet;
/*   8:    */ import java.sql.SQLException;
/*   9:    */ import java.util.ArrayList;
/*  10:    */ import java.util.List;
/*  11:    */ import java.util.logging.Level;
/*  12:    */ import java.util.logging.Logger;
/*  13:    */ 
/*  14:    */ public class Desreforma_ERPDAO
/*  15:    */ {
/*  16:    */   private Connection connection;
/*  17:    */   
/*  18:    */   public Desreforma_ERPDAO()
/*  19:    */   {
/*  20:    */     try
/*  21:    */     {
/*  22: 28 */       this.connection = ConnectionFactory.getInstance().obterConexao();
/*  23:    */     }
/*  24:    */     catch (SQLException ex)
/*  25:    */     {
/*  26: 30 */       Logger.getLogger(Desreforma_ERPDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  27:    */     }
/*  28:    */     catch (ClassNotFoundException ex)
/*  29:    */     {
/*  30: 32 */       Logger.getLogger(Desreforma_ERPDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  31:    */     }
/*  32:    */     catch (Exception ex)
/*  33:    */     {
/*  34: 34 */       Logger.getLogger(Desreforma_ERPDAO.class.getName()).log(Level.SEVERE, null, ex);
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
/*  47:    */   public List<Desreforma_ERP> listarTodos()
/*  48:    */     throws SQLException, ClassNotFoundException, Exception
/*  49:    */   {
/*  50: 51 */     String sql = "SELECT ALL * FROM DESREFORMA_ERP";
/*  51: 52 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/*  52: 53 */     stmt.executeQuery();
/*  53: 54 */     ResultSet rs = stmt.getResultSet();
/*  54: 55 */     List<Desreforma_ERP> desenhos = new ArrayList();
/*  55: 56 */     while (rs.next())
/*  56:    */     {
/*  57: 57 */       Desreforma_ERP desenho = new Desreforma_ERP();
/*  58: 58 */       desenho.setCodDE(rs.getString("CodDE"));
/*  59: 59 */       desenho.setDescrDE(rs.getString("DescrDE"));
/*  60: 60 */       desenho.setSdtDE(rs.getString("SdtDE"));
/*  61: 61 */       desenho.setSulcoDE(rs.getBigDecimal("SulcoDE"));
/*  62: 62 */       desenho.setBlde(rs.getString("Blde"));
/*  63: 63 */       desenho.setLargDE(rs.getBigDecimal("LargDE"));
/*  64: 64 */       desenho.setGenDE(rs.getString("GenDE"));
/*  65: 65 */       desenho.setCodBanDE(rs.getString("CodBanDE"));
/*  66: 66 */       desenho.setPesoDE(rs.getBigDecimal("PesoDE"));
/*  67: 67 */       desenho.setStEI(rs.getInt("StEI"));
/*  68: 68 */       desenhos.add(desenho);
/*  69:    */     }
/*  70: 70 */     stmt.close();
/*  71: 71 */     return desenhos;
/*  72:    */   }
/*  73:    */   
/*  74:    */   public List<Desreforma_ERP> listarNovos()
/*  75:    */     throws SQLException, ClassNotFoundException, Exception
/*  76:    */   {
/*  77: 78 */     String sql = "SELECT * FROM DESREFORMA_ERP WHERE StEI <> 1";
/*  78: 79 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/*  79: 80 */     stmt.executeQuery();
/*  80: 81 */     ResultSet rs = stmt.getResultSet();
/*  81: 82 */     List<Desreforma_ERP> desenhos = new ArrayList();
/*  82: 83 */     while (rs.next())
/*  83:    */     {
/*  84: 84 */       Desreforma_ERP desenho = new Desreforma_ERP();
/*  85: 85 */       desenho.setCodDE(rs.getString("CodDE"));
/*  86: 86 */       desenho.setDescrDE(rs.getString("DescrDE"));
/*  87: 87 */       desenho.setSdtDE(rs.getString("SdtDE"));
/*  88: 88 */       desenho.setSulcoDE(rs.getBigDecimal("SulcoDE"));
/*  89: 89 */       desenho.setBlde(rs.getString("Blde"));
/*  90: 90 */       desenho.setLargDE(rs.getBigDecimal("LargDE"));
/*  91: 91 */       desenho.setGenDE(rs.getString("GenDE"));
/*  92: 92 */       desenho.setCodBanDE(rs.getString("CodBanDE"));
/*  93: 93 */       desenho.setPesoDE(rs.getBigDecimal("PesoDE"));
/*  94: 94 */       desenho.setStEI(rs.getInt("StEI"));
/*  95: 95 */       desenhos.add(desenho);
/*  96:    */     }
/*  97: 97 */     stmt.close();
/*  98: 98 */     return desenhos;
/*  99:    */   }
/* 100:    */   
/* 101:    */   public void atualizar(Desreforma_ERP desenho)
/* 102:    */     throws SQLException, ClassNotFoundException, Exception
/* 103:    */   {
/* 104:105 */     String sql = "UPDATE DESREFORMA_ERP SET DescrDE = ?, SdtDE = ?, SulcoDE = ?, Blde = ?, LargDE = ?, GenDE = ?, CodBanDE = ?, PesoDE = ?, StEI = ?  WHERE CodDE = ?";
/* 105:    */     
/* 106:    */ 
/* 107:108 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 108:109 */     stmt.setString(1, desenho.getDescrDE());
/* 109:110 */     stmt.setString(2, desenho.getSdtDE());
/* 110:111 */     stmt.setBigDecimal(3, desenho.getSulcoDE());
/* 111:112 */     stmt.setString(4, desenho.getBlde());
/* 112:113 */     stmt.setBigDecimal(5, desenho.getLargDE());
/* 113:114 */     stmt.setString(6, desenho.getGenDE());
/* 114:115 */     stmt.setString(7, desenho.getCodBanDE());
/* 115:116 */     stmt.setBigDecimal(8, desenho.getPesoDE());
/* 116:117 */     stmt.setInt(9, desenho.getStEI());
/* 117:118 */     stmt.setString(10, desenho.getCodDE());
/* 118:119 */     stmt.executeUpdate();
/* 119:120 */     stmt.close();
/* 120:    */   }
/* 121:    */ }


/* Location:           C:\Users\Leonardo\Desktop\INT\InterpSync.jar
 * Qualified Name:     br.com.interpsync.retreadsystem.dao.Desreforma_ERPDAO
 * JD-Core Version:    0.7.0.1
 */