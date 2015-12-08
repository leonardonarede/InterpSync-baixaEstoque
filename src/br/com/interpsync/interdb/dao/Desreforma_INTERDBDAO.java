/*   1:    */ package br.com.interpsync.interdb.dao;
/*   2:    */ 
/*   3:    */ import br.com.interpsync.interdb.jdbc.ConnectionFactoryInterDB;
/*   4:    */ import br.com.interpsync.retreadsystem.modelo.Desreforma_ERP;
/*   5:    */ import java.sql.Connection;
/*   6:    */ import java.sql.PreparedStatement;
/*   7:    */ import java.sql.ResultSet;
/*   8:    */ import java.sql.SQLException;
/*   9:    */ import java.util.logging.Level;
/*  10:    */ import java.util.logging.Logger;
/*  11:    */ 
/*  12:    */ public class Desreforma_INTERDBDAO
/*  13:    */ {
/*  14:    */   private Connection connection;
/*  15:    */   
/*  16:    */   public Desreforma_INTERDBDAO()
/*  17:    */   {
/*  18:    */     try
/*  19:    */     {
/*  20: 25 */       this.connection = ConnectionFactoryInterDB.getInstance().obterConexao();
/*  21:    */     }
/*  22:    */     catch (SQLException ex)
/*  23:    */     {
/*  24: 27 */       Logger.getLogger(Clientes_INTERDBDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  25:    */     }
/*  26:    */     catch (ClassNotFoundException ex)
/*  27:    */     {
/*  28: 29 */       Logger.getLogger(Clientes_INTERDBDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  29:    */     }
/*  30:    */     catch (Exception ex)
/*  31:    */     {
/*  32: 31 */       Logger.getLogger(Clientes_INTERDBDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  33:    */     }
/*  34:    */   }
/*  35:    */   
/*  36:    */   public Connection getConnection()
/*  37:    */     throws SQLException, ClassNotFoundException, Exception
/*  38:    */   {
/*  39: 39 */     if ((this.connection == null) || (this.connection.isClosed())) {
/*  40: 40 */       this.connection = ConnectionFactoryInterDB.getInstance().obterConexao();
/*  41:    */     }
/*  42: 42 */     return this.connection;
/*  43:    */   }
/*  44:    */   
/*  45:    */   public void inserir(Desreforma_ERP desenho)
/*  46:    */     throws ClassNotFoundException, SQLException, Exception
/*  47:    */   {
/*  48: 49 */     String sql = "INSERT INTO DESREFORMA_ERP (CodDE,DescrDE,SdtDE,SulcoDE,Blde,LargDE,GenDE,CodBanDE,PesoDE,StEI)    VALUES (?,?,?,?,?,?,?,?,?,?)";
/*  49:    */     
/*  50: 51 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/*  51: 52 */     stmt.setString(1, desenho.getCodDE());
/*  52: 53 */     stmt.setString(2, desenho.getDescrDE());
/*  53: 54 */     stmt.setString(3, desenho.getSdtDE());
/*  54: 55 */     stmt.setBigDecimal(4, desenho.getSulcoDE());
/*  55: 56 */     stmt.setString(5, desenho.getBlde());
/*  56: 57 */     stmt.setBigDecimal(6, desenho.getLargDE());
/*  57: 58 */     stmt.setString(7, desenho.getGenDE());
/*  58: 59 */     stmt.setString(8, desenho.getCodBanDE());
/*  59: 60 */     stmt.setBigDecimal(9, desenho.getPesoDE());
/*  60: 61 */     stmt.setInt(10, desenho.getStEI());
/*  61: 62 */     stmt.executeUpdate();
/*  62: 63 */     stmt.close();
/*  63:    */   }
/*  64:    */   
/*  65:    */   public void atualizar(Desreforma_ERP desenho)
/*  66:    */     throws ClassNotFoundException, SQLException, Exception
/*  67:    */   {
/*  68: 70 */     String sql = "UPDATE DESREFORMA_ERP    SET    DescrDE = ?, SdtDE = ?, SulcoDE = ?, Blde = ?,           LargDE = ?, GenDE = ?, CodBanDE = ?, PesoDE = ?, StEI = ?    WHERE  CodDE = ?";
/*  69:    */     
/*  70:    */ 
/*  71:    */ 
/*  72: 74 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/*  73: 75 */     stmt.setString(1, desenho.getDescrDE());
/*  74: 76 */     stmt.setString(2, desenho.getSdtDE());
/*  75: 77 */     stmt.setBigDecimal(3, desenho.getSulcoDE());
/*  76: 78 */     stmt.setString(4, desenho.getBlde());
/*  77: 79 */     stmt.setBigDecimal(5, desenho.getLargDE());
/*  78: 80 */     stmt.setString(6, desenho.getGenDE());
/*  79: 81 */     stmt.setString(7, desenho.getCodBanDE());
/*  80: 82 */     stmt.setBigDecimal(8, desenho.getPesoDE());
/*  81: 83 */     stmt.setInt(9, desenho.getStEI());
/*  82: 84 */     stmt.setString(10, desenho.getCodDE());
/*  83: 85 */     stmt.executeUpdate();
/*  84: 86 */     stmt.close();
/*  85:    */   }
/*  86:    */   
/*  87:    */   public Desreforma_ERP localizarPorID(String id)
/*  88:    */     throws ClassNotFoundException, SQLException, Exception
/*  89:    */   {
/*  90: 93 */     String sql = "SELECT CodDE, DescrDE, SdtDE, SulcoDE, Blde, LargDE, GenDE, CodBanDE, PesoDE, StEI    FROM DESREFORMA_ERP WHERE CodDE = ?";
/*  91:    */     
/*  92: 95 */     Desreforma_ERP desenho = new Desreforma_ERP();
/*  93: 96 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/*  94: 97 */     stmt.setString(1, id);
/*  95: 98 */     stmt.executeQuery();
/*  96: 99 */     ResultSet rs = stmt.getResultSet();
/*  97:100 */     if (rs.next())
/*  98:    */     {
/*  99:101 */       desenho.setCodDE(rs.getString("CodDE"));
/* 100:102 */       desenho.setDescrDE(rs.getString("DescrDE"));
/* 101:103 */       desenho.setSdtDE(rs.getString("SdtDE"));
/* 102:104 */       desenho.setSulcoDE(rs.getBigDecimal("SulcoDE"));
/* 103:105 */       desenho.setBlde(rs.getString("Blde"));
/* 104:106 */       desenho.setLargDE(rs.getBigDecimal("LargDE"));
/* 105:107 */       desenho.setGenDE(rs.getString("GenDE"));
/* 106:108 */       desenho.setCodBanDE(rs.getString("CodBanDE"));
/* 107:109 */       desenho.setPesoDE(rs.getBigDecimal("PesoDE"));
/* 108:110 */       desenho.setStEI(rs.getInt("StEI"));
/* 109:    */     }
/* 110:112 */     stmt.close();
/* 111:113 */     return desenho;
/* 112:    */   }
/* 113:    */ }


/* Location:           C:\Users\Leonardo\Desktop\INT\InterpSync.jar
 * Qualified Name:     br.com.interpsync.interdb.dao.Desreforma_INTERDBDAO
 * JD-Core Version:    0.7.0.1
 */