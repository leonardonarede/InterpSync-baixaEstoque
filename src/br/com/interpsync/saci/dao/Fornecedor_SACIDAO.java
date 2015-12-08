/*   1:    */ package br.com.interpsync.saci.dao;
/*   2:    */ 
/*   3:    */ import br.com.interpsync.saci.jdbc.ConnectionFactorySACI;
/*   4:    */ import br.com.interpsync.saci.modelo.Fornecedor_SACI;
/*   5:    */ import java.sql.Connection;
/*   6:    */ import java.sql.PreparedStatement;
/*   7:    */ import java.sql.ResultSet;
/*   8:    */ import java.sql.SQLException;
/*   9:    */ import java.util.logging.Level;
/*  10:    */ import java.util.logging.Logger;
/*  11:    */ 
/*  12:    */ public class Fornecedor_SACIDAO
/*  13:    */ {
/*  14:    */   private Connection conexao;
/*  15:    */   
/*  16:    */   public Fornecedor_SACIDAO()
/*  17:    */   {
/*  18:    */     try
/*  19:    */     {
/*  20: 25 */       this.conexao = ConnectionFactorySACI.getInstance().obterConexao();
/*  21:    */     }
/*  22:    */     catch (SQLException ex)
/*  23:    */     {
/*  24: 27 */       Logger.getLogger(Prd_SACIDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  25:    */     }
/*  26:    */     catch (ClassNotFoundException ex)
/*  27:    */     {
/*  28: 29 */       Logger.getLogger(Prd_SACIDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  29:    */     }
/*  30:    */     catch (Exception ex)
/*  31:    */     {
/*  32: 31 */       Logger.getLogger(Prd_SACIDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  33:    */     }
/*  34:    */   }
/*  35:    */   
/*  36:    */   public Connection getConnection()
/*  37:    */     throws SQLException, ClassNotFoundException, Exception
/*  38:    */   {
/*  39: 39 */     if ((this.conexao == null) || (this.conexao.isClosed())) {
/*  40: 40 */       this.conexao = ConnectionFactorySACI.getInstance().obterConexao();
/*  41:    */     }
/*  42: 42 */     return this.conexao;
/*  43:    */   }
/*  44:    */   
/*  45:    */   public void inserir(Fornecedor_SACI forn)
/*  46:    */     throws ClassNotFoundException, Exception
/*  47:    */   {
/*  48: 48 */     String sql = "INSERT INTO vend    (no, name, sname, cgc, insc,  nei, city, state, auxChar1, zip, ext, coll, fabOufor,     l1, l2, l3, l4, l5, l6, l7, l8, m1, m2, m3, m4, m5, m6, m7, m8, auxShort4, s1, s2, s3,     s4, s5, s6, s7, s8, addr, c1, wshash) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,  ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
/*  49:    */     
/*  50:    */ 
/*  51:    */ 
/*  52:    */ 
/*  53: 53 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/*  54: 54 */     stmt.setInt(1, forn.getNo().intValue());
/*  55: 55 */     stmt.setString(2, forn.getName());
/*  56: 56 */     stmt.setString(3, forn.getSname());
/*  57: 57 */     stmt.setString(4, forn.getCgc());
/*  58: 58 */     stmt.setString(5, forn.getInsc());
/*  59: 59 */     stmt.setString(6, forn.getNei());
/*  60: 60 */     stmt.setString(7, forn.getCity());
/*  61: 61 */     stmt.setString(8, forn.getState());
/*  62: 62 */     stmt.setString(9, forn.getAuxChar1());
/*  63: 63 */     stmt.setInt(10, forn.getZip().intValue());
/*  64: 64 */     stmt.setString(11, forn.getExt());
/*  65: 65 */     stmt.setString(12, forn.getColl());
/*  66: 66 */     stmt.setInt(13, forn.getFabOufor().intValue());
/*  67: 67 */     stmt.setInt(14, forn.getL1().intValue());
/*  68: 68 */     stmt.setInt(15, forn.getL2().intValue());
/*  69: 69 */     stmt.setInt(16, forn.getL3().intValue());
/*  70: 70 */     stmt.setInt(17, forn.getL4().intValue());
/*  71: 71 */     stmt.setInt(18, forn.getL5().intValue());
/*  72: 72 */     stmt.setInt(19, forn.getL6().intValue());
/*  73: 73 */     stmt.setInt(20, forn.getL7().intValue());
/*  74: 74 */     stmt.setInt(21, forn.getL8().intValue());
/*  75: 75 */     stmt.setInt(22, forn.getM1().intValue());
/*  76: 76 */     stmt.setInt(23, forn.getM2().intValue());
/*  77: 77 */     stmt.setInt(24, forn.getM3().intValue());
/*  78: 78 */     stmt.setInt(25, forn.getM4().intValue());
/*  79: 79 */     stmt.setInt(26, forn.getM5().intValue());
/*  80: 80 */     stmt.setInt(27, forn.getM6().intValue());
/*  81: 81 */     stmt.setInt(28, forn.getM7().intValue());
/*  82: 82 */     stmt.setInt(29, forn.getM8().intValue());
/*  83: 83 */     stmt.setInt(30, forn.getAuxShort4().intValue());
/*  84: 84 */     stmt.setInt(31, forn.getS1().intValue());
/*  85: 85 */     stmt.setInt(32, forn.getS2().intValue());
/*  86: 86 */     stmt.setInt(33, forn.getS3().intValue());
/*  87: 87 */     stmt.setInt(34, forn.getS4().intValue());
/*  88: 88 */     stmt.setInt(35, forn.getS5().intValue());
/*  89: 89 */     stmt.setInt(36, forn.getS6().intValue());
/*  90: 90 */     stmt.setInt(37, forn.getS7().intValue());
/*  91: 91 */     stmt.setInt(38, forn.getS8().intValue());
/*  92: 92 */     stmt.setString(39, forn.getAddr());
/*  93: 93 */     stmt.setString(40, forn.getC1());
/*  94: 94 */     stmt.setString(41, forn.getWshash());
/*  95: 95 */     stmt.executeUpdate();
/*  96: 96 */     stmt.close();
/*  97:    */   }
/*  98:    */   
/*  99:    */   public Fornecedor_SACI buscar(String cpfcgc)
/* 100:    */     throws ClassNotFoundException, Exception
/* 101:    */   {
/* 102:102 */     String sql = "SELECT no, name, sname, cgc, insc, nei, city, state, auxChar1, zip, ext, coll, fabOufor   FROM   vend WHERE cgc = ? ";
/* 103:    */     
/* 104:104 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 105:105 */     stmt.setString(1, cpfcgc);
/* 106:106 */     stmt.executeQuery();
/* 107:107 */     ResultSet rs = stmt.getResultSet();
/* 108:108 */     Fornecedor_SACI forn = new Fornecedor_SACI();
/* 109:109 */     if (rs.next())
/* 110:    */     {
/* 111:110 */       forn.setNo(Integer.valueOf(rs.getInt("no")));
/* 112:111 */       forn.setName(rs.getString("name"));
/* 113:112 */       forn.setSname(rs.getString("sname"));
/* 114:113 */       forn.setCgc(rs.getString("cgc"));
/* 115:114 */       forn.setInsc(rs.getString("insc"));
/* 116:115 */       forn.setNei(rs.getString("nei"));
/* 117:116 */       forn.setCity(rs.getString("city"));
/* 118:117 */       forn.setState(rs.getString("state"));
/* 119:118 */       forn.setAuxChar1(rs.getString("auxChar1"));
/* 120:119 */       forn.setZip(Integer.valueOf(rs.getInt("zip")));
/* 121:120 */       forn.setExt(rs.getString("ext"));
/* 122:121 */       forn.setColl(rs.getString("coll"));
/* 123:122 */       forn.setFabOufor(Integer.valueOf(rs.getInt("fabOufor")));
/* 124:    */     }
/* 125:124 */     return forn;
/* 126:    */   }
/* 127:    */   
/* 128:    */   public Integer buscarUltimo()
/* 129:    */     throws ClassNotFoundException, Exception
/* 130:    */   {
/* 131:130 */     String sql = "SELECT MAX(vend.no) AS ultimo FROM vend";
/* 132:131 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 133:132 */     stmt.executeQuery();
/* 134:133 */     ResultSet rs = stmt.getResultSet();
/* 135:134 */     Integer ultimo = null;
/* 136:135 */     if (rs.next()) {
/* 137:136 */       ultimo = Integer.valueOf(rs.getInt("ultimo") + 1);
/* 138:    */     }
/* 139:138 */     return ultimo;
/* 140:    */   }
/* 141:    */ }


/* Location:           C:\Users\Leonardo\Desktop\INT\InterpSync.jar
 * Qualified Name:     br.com.interpsync.saci.dao.Fornecedor_SACIDAO
 * JD-Core Version:    0.7.0.1
 */