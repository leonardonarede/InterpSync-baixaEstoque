/*   1:    */ package br.com.interpsync.retreadsystem.dao;
/*   2:    */ 
/*   3:    */ import br.com.interpsync.retreadsystem.jdbc.ConnectionFactory;
/*   4:    */ import br.com.interpsync.retreadsystem.modelo.Osvr_ERP;
/*   5:    */ import java.io.PrintStream;
/*   6:    */ import java.sql.Connection;
/*   7:    */ import java.sql.PreparedStatement;
/*   8:    */ import java.sql.ResultSet;
/*   9:    */ import java.sql.SQLException;
/*  10:    */ import java.util.ArrayList;
/*  11:    */ import java.util.List;
/*  12:    */ import java.util.logging.Level;
/*  13:    */ import java.util.logging.Logger;
/*  14:    */ 
/*  15:    */ public class Osvr_ERPDAO
/*  16:    */ {
/*  17:    */   private Connection connection;
/*  18:    */   
/*  19:    */   public Osvr_ERPDAO()
/*  20:    */   {
/*  21:    */     try
/*  22:    */     {
/*  23: 27 */       this.connection = ConnectionFactory.getInstance().obterConexao();
/*  24:    */     }
/*  25:    */     catch (SQLException ex)
/*  26:    */     {
/*  27: 29 */       Logger.getLogger(Osvr_ERPDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  28:    */     }
/*  29:    */     catch (ClassNotFoundException ex)
/*  30:    */     {
/*  31: 31 */       Logger.getLogger(Osvr_ERPDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  32:    */     }
/*  33:    */     catch (Exception ex)
/*  34:    */     {
/*  35: 33 */       Logger.getLogger(Osvr_ERPDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  36:    */     }
/*  37:    */   }
/*  38:    */   
/*  39:    */   public Connection getConnection()
/*  40:    */     throws SQLException, ClassNotFoundException, Exception
/*  41:    */   {
/*  42: 41 */     if ((this.connection == null) || (this.connection.isClosed())) {
/*  43: 42 */       this.connection = ConnectionFactory.getInstance().obterConexao();
/*  44:    */     }
/*  45: 44 */     return this.connection;
/*  46:    */   }
/*  47:    */   
/*  48:    */   public List<Osvr_ERP> listarTodos()
/*  49:    */     throws SQLException, ClassNotFoundException, Exception
/*  50:    */   {
/*  51: 50 */     String sql = "SELECT ALL * FROM OSVR_ERP";
/*  52: 51 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/*  53: 52 */     stmt.executeQuery();
/*  54: 53 */     ResultSet rs = stmt.getResultSet();
/*  55: 54 */     List<Osvr_ERP> lista = new ArrayList();
/*  56: 55 */     while (rs.next())
/*  57:    */     {
/*  58: 56 */       Osvr_ERP osvr = new Osvr_ERP();
/*  59: 57 */       osvr.setNrOS(Integer.valueOf(rs.getInt("NrOS")));
/*  60: 58 */       osvr.setTipoReg(rs.getString("TipoReg"));
/*  61: 59 */       osvr.setCodigoReg(rs.getString("CodigoReg"));
/*  62: 60 */       osvr.setQtde(rs.getBigDecimal("Qtde"));
/*  63: 61 */       osvr.setVrLiquido(rs.getBigDecimal("VrLiquido"));
/*  64: 62 */       osvr.setVrBruto(rs.getBigDecimal("VrBruto"));
/*  65: 63 */       osvr.setFilialTit(rs.getString("FilialTit"));
/*  66: 64 */       lista.add(osvr);
/*  67:    */     }
/*  68: 66 */     stmt.close();
/*  69: 67 */     return lista;
/*  70:    */   }
/*  71:    */   
/*  72:    */   public List<Osvr_ERP> listarNovos()
/*  73:    */     throws SQLException, ClassNotFoundException, Exception
/*  74:    */   {
/*  75: 74 */     String sql = "SELECT NrOS, TipoReg, CodigoReg, Qtde, VrLiquido, VrBruto, FilialTit FROM OSVR_ERP WHERE FilialTit <> ? ";
/*  76: 75 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/*  77: 76 */     stmt.setString(1, "002");
/*  78: 77 */     stmt.executeQuery();
/*  79: 78 */     ResultSet rs = stmt.getResultSet();
/*  80: 79 */     List<Osvr_ERP> lista = new ArrayList();
/*  81: 80 */     while (rs.next()) {
/*  82: 81 */       if (rs.wasNull())
/*  83:    */       {
/*  84: 82 */         System.out.println("vazio");
/*  85:    */       }
/*  86:    */       else
/*  87:    */       {
/*  88: 84 */         Osvr_ERP osvr = new Osvr_ERP();
/*  89: 85 */         osvr.setNrOS(Integer.valueOf(rs.getInt("NrOS")));
/*  90: 86 */         osvr.setTipoReg(rs.getString("TipoReg"));
/*  91: 87 */         osvr.setCodigoReg(rs.getString("CodigoReg"));
/*  92: 88 */         osvr.setQtde(rs.getBigDecimal("Qtde"));
/*  93: 89 */         osvr.setVrLiquido(rs.getBigDecimal("VrLiquido"));
/*  94: 90 */         osvr.setVrBruto(rs.getBigDecimal("VrBruto"));
/*  95: 91 */         osvr.setFilialTit(rs.getString("FilialTit"));
/*  96: 92 */         lista.add(osvr);
/*  97:    */       }
/*  98:    */     }
/*  99: 95 */     stmt.close();
/* 100: 96 */     return lista;
/* 101:    */   }
/* 102:    */   
/* 103:    */   public void atualizar(Osvr_ERP osvr)
/* 104:    */     throws ClassNotFoundException, SQLException, Exception
/* 105:    */   {
/* 106:103 */     String sql = "UPDATE OSVR_ERP SET FilialTit = ? WHERE NrOS = ? AND TipoReg = ? AND CodigoReg = ? ";
/* 107:104 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 108:105 */     stmt.setString(1, osvr.getFilialTit());
/* 109:106 */     stmt.setInt(2, osvr.getNrOS().intValue());
/* 110:107 */     stmt.setString(3, osvr.getTipoReg());
/* 111:108 */     stmt.setString(4, osvr.getCodigoReg());
/* 112:109 */     stmt.executeUpdate();
/* 113:110 */     stmt.close();
/* 114:    */   }
/* 115:    */ }


/* Location:           C:\Users\Leonardo\Desktop\INT\InterpSync.jar
 * Qualified Name:     br.com.interpsync.retreadsystem.dao.Osvr_ERPDAO
 * JD-Core Version:    0.7.0.1
 */