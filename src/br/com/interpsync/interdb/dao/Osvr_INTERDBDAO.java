/*   1:    */ package br.com.interpsync.interdb.dao;
/*   2:    */ 
/*   3:    */ import br.com.interpsync.interdb.jdbc.ConnectionFactoryInterDB;
/*   4:    */ import br.com.interpsync.retreadsystem.modelo.Osvr_ERP;
/*   5:    */ import java.sql.Connection;
/*   6:    */ import java.sql.PreparedStatement;
/*   7:    */ import java.sql.ResultSet;
/*   8:    */ import java.sql.SQLException;
/*   9:    */ import java.util.ArrayList;
/*  10:    */ import java.util.List;
/*  11:    */ import java.util.logging.Level;
/*  12:    */ import java.util.logging.Logger;
/*  13:    */ 
/*  14:    */ public class Osvr_INTERDBDAO
/*  15:    */ {
/*  16:    */   private Connection connection;
/*  17:    */   
/*  18:    */   public Osvr_INTERDBDAO()
/*  19:    */   {
/*  20:    */     try
/*  21:    */     {
/*  22: 27 */       this.connection = ConnectionFactoryInterDB.getInstance().obterConexao();
/*  23:    */     }
/*  24:    */     catch (SQLException ex)
/*  25:    */     {
/*  26: 29 */       Logger.getLogger(Clientes_INTERDBDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  27:    */     }
/*  28:    */     catch (ClassNotFoundException ex)
/*  29:    */     {
/*  30: 31 */       Logger.getLogger(Clientes_INTERDBDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  31:    */     }
/*  32:    */     catch (Exception ex)
/*  33:    */     {
/*  34: 33 */       Logger.getLogger(Clientes_INTERDBDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  35:    */     }
/*  36:    */   }
/*  37:    */   
/*  38:    */   public Connection getConnection()
/*  39:    */     throws SQLException, ClassNotFoundException, Exception
/*  40:    */   {
/*  41: 41 */     if ((this.connection == null) || (this.connection.isClosed())) {
/*  42: 42 */       this.connection = ConnectionFactoryInterDB.getInstance().obterConexao();
/*  43:    */     }
/*  44: 44 */     return this.connection;
/*  45:    */   }
/*  46:    */   
/*  47:    */   public void inserir(Osvr_ERP osvr)
/*  48:    */     throws SQLException, ClassNotFoundException, Exception
/*  49:    */   {
/*  50: 51 */     String sql = "INSERT INTO OSVR_ERP (NrOS,TipoReg,CodigoReg,Qtde,VrLiquido,VrBruto,FilialTit,OSVRID) VALUES (?,?,?,?,?,?,?,?)";
/*  51:    */     
/*  52: 53 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/*  53: 54 */     stmt.setInt(1, osvr.getNrOS().intValue());
/*  54: 55 */     stmt.setString(2, osvr.getTipoReg());
/*  55: 56 */     stmt.setString(3, osvr.getCodigoReg());
/*  56: 57 */     stmt.setBigDecimal(4, osvr.getQtde());
/*  57: 58 */     stmt.setBigDecimal(5, osvr.getVrLiquido());
/*  58: 59 */     stmt.setBigDecimal(6, osvr.getVrBruto());
/*  59: 60 */     stmt.setString(7, osvr.getFilialTit());
                  stmt.setInt(8,osvr.getOSVRID());
/*  60: 61 */     stmt.executeUpdate();
/*  61: 62 */     stmt.close();
/*  62:    */   }
/*  63:    */   
/*  64:    */   public void atualizar(Osvr_ERP osvr)
/*  65:    */     throws ClassNotFoundException, SQLException, Exception
/*  66:    */   {
/*  67: 69 */     String sql = "UPDATE OSVR_ERP    SET    Qtde = ?, VrLiquido = ?,          VrBruto = ?, FilialTit = ?, StatusERP = ?   WHERE  NrOS = ? AND TipoReg = ? AND CodigoReg = ? AND OSVRID = ?";
/*  68:    */     
/*  69:    */ 
/*  70:    */ 
/*  71: 73 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/*  72: 74 */     stmt.setBigDecimal(1, osvr.getQtde());
/*  73: 75 */     stmt.setBigDecimal(2, osvr.getVrLiquido());
/*  74: 76 */     stmt.setBigDecimal(3, osvr.getVrBruto());
/*  75: 77 */     stmt.setString(4, osvr.getFilialTit());
/*  76: 78 */     stmt.setInt(5, osvr.getStatusERP());
/*  77: 79 */     stmt.setInt(6, osvr.getNrOS().intValue());
/*  78: 80 */     stmt.setString(7, osvr.getTipoReg());
/*  79: 81 */     stmt.setString(8, osvr.getCodigoReg());
                  stmt.setInt(9,osvr.getOSVRID());
/*  80: 82 */     stmt.executeUpdate();
/*  81: 83 */     stmt.close();
/*  82:    */   }
/*  83:    */   
/*  84:    */   public Osvr_ERP localizarPorID(Integer nos, String tiporeg, String codreg, Integer osvrid)
/*  85:    */     throws ClassNotFoundException, SQLException, Exception
/*  86:    */   {
/*  87: 90 */     String sql = "SELECT NrOS, TipoReg, CodigoReg, Qtde, VrLiquido, VrBruto, FilialTit, StatusERP FROM OSVR_ERP    WHERE NrOS = ? AND TipoReg = ? AND CodigoReg = ? AND OSVRID = ? ";
/*  88:    */     
/*  89: 92 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/*  90: 93 */     stmt.setInt(1, nos.intValue());
/*  91: 94 */     stmt.setString(2, tiporeg);
/*  92: 95 */     stmt.setString(3, codreg);
                  stmt.setInt(4,osvrid);
/*  93: 96 */     stmt.executeQuery();
/*  94: 97 */     ResultSet rs = stmt.getResultSet();
/*  95: 98 */     Osvr_ERP osvr = new Osvr_ERP();
/*  96: 99 */     if (rs.next())
/*  97:    */     {
/*  98:100 */       osvr.setNrOS(Integer.valueOf(rs.getInt("NrOS")));
/*  99:101 */       osvr.setTipoReg(rs.getString("TipoReg"));
/* 100:102 */       osvr.setCodigoReg(rs.getString("CodigoReg"));
/* 101:103 */       osvr.setQtde(rs.getBigDecimal("Qtde"));
/* 102:104 */       osvr.setVrLiquido(rs.getBigDecimal("VrLiquido"));
/* 103:105 */       osvr.setVrBruto(rs.getBigDecimal("VrBruto"));
/* 104:106 */       osvr.setFilialTit(rs.getString("FilialTit"));
/* 105:107 */       osvr.setStatusERP(rs.getInt("StatusERP"));
/* 106:    */     }
/* 107:109 */     stmt.close();
/* 108:110 */     return osvr;
/* 109:    */   }
/* 110:    */   
/* 111:    */   public List<Osvr_ERP> listarPendentes()
/* 112:    */     throws ClassNotFoundException, SQLException, Exception
/* 113:    */   {
/* 114:117 */     String sql = "SELECT * FROM OSVR_ERP WHERE StatusERP = 0";
/* 115:118 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 116:119 */     stmt.executeQuery();
/* 117:120 */     ResultSet rs = stmt.getResultSet();
/* 118:121 */     List<Osvr_ERP> lista = new ArrayList();
/* 119:122 */     while (rs.next())
/* 120:    */     {
/* 121:123 */       Osvr_ERP osvr = new Osvr_ERP();
/* 122:124 */       osvr.setNrOS(Integer.valueOf(rs.getInt("NrOS")));
/* 123:125 */       osvr.setTipoReg(rs.getString("TipoReg"));
/* 124:126 */       osvr.setCodigoReg(rs.getString("CodigoReg"));
/* 125:127 */       osvr.setQtde(rs.getBigDecimal("Qtde"));
/* 126:128 */       osvr.setVrLiquido(rs.getBigDecimal("VrLiquido"));
/* 127:129 */       osvr.setVrBruto(rs.getBigDecimal("VrBruto"));
/* 128:130 */       osvr.setFilialTit(rs.getString("FilialTit"));
                    osvr.setOSVRID(rs.getInt("OSVRID"));
/* 129:131 */       lista.add(osvr);
/* 130:    */     }
/* 131:133 */     stmt.close();
/* 132:134 */     return lista;
/* 133:    */   }
/* 134:    */ }



/* Location:           C:\Users\Leonardo\Desktop\INT\InterpSync.jar

 * Qualified Name:     br.com.interpsync.interdb.dao.Osvr_INTERDBDAO

 * JD-Core Version:    0.7.0.1

 */