/*   1:    */ package br.com.interpsync.retreadsystem.dao;
/*   2:    */ 
/*   3:    */ import br.com.interpsync.retreadsystem.jdbc.ConnectionFactory;
/*   4:    */ import br.com.interpsync.retreadsystem.modelo.OS_ERP;
/*   5:    */ import java.sql.Connection;
/*   6:    */ import java.sql.PreparedStatement;
/*   7:    */ import java.sql.ResultSet;
/*   8:    */ import java.sql.SQLException;
/*   9:    */ import java.util.ArrayList;
/*  10:    */ import java.util.Calendar;
/*  11:    */ import java.util.List;
/*  12:    */ import java.util.logging.Level;
/*  13:    */ import java.util.logging.Logger;
/*  14:    */ 
/*  15:    */ public class OS_ERPDAO
/*  16:    */ {
/*  17:    */   private Connection connection;
/*  18:    */   
/*  19:    */   public OS_ERPDAO()
/*  20:    */   {
/*  21:    */     try
/*  22:    */     {
/*  23: 29 */       this.connection = ConnectionFactory.getInstance().obterConexao();
/*  24:    */     }
/*  25:    */     catch (SQLException ex)
/*  26:    */     {
/*  27: 31 */       Logger.getLogger(OS_ERPDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  28:    */     }
/*  29:    */     catch (ClassNotFoundException ex)
/*  30:    */     {
/*  31: 33 */       Logger.getLogger(OS_ERPDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  32:    */     }
/*  33:    */     catch (Exception ex)
/*  34:    */     {
/*  35: 35 */       Logger.getLogger(OS_ERPDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  36:    */     }
/*  37:    */   }
/*  38:    */   
/*  39:    */   public Connection getConnection()
/*  40:    */     throws SQLException, ClassNotFoundException, Exception
/*  41:    */   {
/*  42: 43 */     if ((this.connection == null) || (this.connection.isClosed())) {
/*  43: 44 */       this.connection = ConnectionFactory.getInstance().obterConexao();
/*  44:    */     }
/*  45: 46 */     return this.connection;
/*  46:    */   }
/*  47:    */   
/*  48:    */   public List<OS_ERP> listarTodos()
/*  49:    */     throws SQLException, ClassNotFoundException, Exception
/*  50:    */   {
/*  51: 52 */     String sql = "SELECT ALL * FROM OS_ERP";
/*  52: 53 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/*  53: 54 */     stmt.executeQuery();
/*  54: 55 */     ResultSet rs = stmt.getResultSet();
/*  55: 56 */     List<OS_ERP> lista = new ArrayList();
/*  56: 57 */     while (rs.next())
/*  57:    */     {
/*  58: 58 */       OS_ERP os = new OS_ERP();
/*  59: 59 */       os.setNrOS(Integer.valueOf(rs.getInt("NrOS")));
/*  60: 60 */       os.setNrLote(Integer.valueOf(rs.getInt("NrLote")));
/*  61: 61 */       os.setClienteID(rs.getString("ClienteID"));
/*  62: 62 */       os.setPneuID(rs.getString("PneuID"));
/*  63: 63 */       os.setNrMatricula(rs.getString("NrMatricula"));
/*  64: 64 */       os.setDotID(rs.getString("DotID"));
/*  65: 65 */       os.setMedidaID(rs.getString("MedidaID"));
/*  66: 66 */       os.setMarcaID(rs.getString("MarcaID"));
/*  67: 67 */       os.setModeloID(rs.getString("ModeloID"));
/*  68: 68 */       os.setStatusID(rs.getString("StatusID"));
/*  69: 69 */       os.setLRID(rs.getString("LRID"));
/*  70: 70 */       os.setVendedorID(rs.getString("VendedorID"));
/*  71: 71 */       os.setColetadorID(rs.getString("ColetadorID"));
/*  72: 72 */       os.setPrazoID(rs.getString("PrazoID"));
/*  73: 74 */       if (rs.getDate("DtEmisID") != null) {
/*  74: 75 */         os.setDtEmisID(rs.getDate("DtEmisID"));
/*  75:    */       } else {
/*  76: 77 */         os.setDtEmisID(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
/*  77:    */       }
/*  78: 79 */       if (rs.getDate("DtprodID") != null) {
/*  79: 80 */         os.setDtprodID(rs.getDate("DtprodID"));
/*  80:    */       } else {
/*  81: 82 */         os.setDtprodID(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
/*  82:    */       }
/*  83: 84 */       if (rs.getDate("DtPrefID") != null) {
/*  84: 85 */         os.setDtPrefID(rs.getDate("DtPrefID"));
/*  85:    */       } else {
/*  86: 87 */         os.setDtPrefID(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
/*  87:    */       }
/*  88: 90 */       os.setSolicitadoID(rs.getString("SolicitadoID"));
/*  89: 91 */       os.setMotivoID(rs.getString("MotivoID"));
/*  90: 92 */       os.setValorCarc(rs.getBigDecimal("ValorCarc"));
/*  91: 93 */       os.setDescRef(rs.getBigDecimal("DescRef"));
/*  92: 94 */       os.setDescRep(rs.getBigDecimal("DescRep"));
/*  93: 95 */       os.setFatRef(rs.getBigDecimal("FatRef"));
/*  94: 96 */       os.setFatRep(rs.getBigDecimal("FatRep"));
/*  95: 97 */       os.setStEI(rs.getInt("StEI"));
/*  96: 98 */       os.setVrCom(rs.getBigDecimal("VrCom"));
/*  97: 99 */       os.setLauFDC(rs.getString("LauFDC"));
/*  98:100 */       os.setLauFFC(rs.getString("LauFFC"));
/*  99:    */       
/* 100:102 */       lista.add(os);
/* 101:    */     }
/* 102:104 */     stmt.close();
/* 103:105 */     return lista;
/* 104:    */   }
/* 105:    */   
/* 106:    */   public List<OS_ERP> listarNovos()
/* 107:    */     throws SQLException, ClassNotFoundException, Exception
/* 108:    */   {
/* 109:112 */     String sql = "SELECT ALL * FROM OS_ERP WHERE StEI <> 2 AND StEI <> 5 ";
/* 110:113 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 111:114 */     stmt.executeQuery();
/* 112:115 */     ResultSet rs = stmt.getResultSet();
/* 113:116 */     List<OS_ERP> lista = new ArrayList();
/* 114:117 */     while (rs.next())
/* 115:    */     {
/* 116:118 */       OS_ERP os = new OS_ERP();
/* 117:119 */       os.setNrOS(Integer.valueOf(rs.getInt("NrOS")));
/* 118:120 */       os.setNrLote(Integer.valueOf(rs.getInt("NrLote")));
/* 119:121 */       os.setClienteID(rs.getString("ClienteID"));
/* 120:122 */       os.setPneuID(rs.getString("PneuID"));
/* 121:123 */       os.setNrMatricula(rs.getString("NrMatricula"));
/* 122:124 */       os.setDotID(rs.getString("DotID"));
/* 123:125 */       os.setMedidaID(rs.getString("MedidaID"));
/* 124:126 */       os.setMarcaID(rs.getString("MarcaID"));
/* 125:127 */       os.setModeloID(rs.getString("ModeloID"));
/* 126:128 */       os.setStatusID(rs.getString("StatusID"));
/* 127:129 */       os.setLRID(rs.getString("LRID"));
/* 128:130 */       os.setVendedorID(rs.getString("VendedorID"));
/* 129:131 */       os.setColetadorID(rs.getString("ColetadorID"));
/* 130:132 */       os.setPrazoID(rs.getString("PrazoID"));
/* 131:    */       
/* 132:134 */       Calendar data1 = Calendar.getInstance();
/* 133:135 */       if (rs.getDate("DtEmisID") != null) {
/* 134:136 */         os.setDtEmisID(rs.getDate("DtEmisID"));
/* 135:    */       }
/* 136:138 */       Calendar data2 = Calendar.getInstance();
/* 137:139 */       if (rs.getDate("DtprodID") != null) {
/* 138:140 */         os.setDtprodID(rs.getDate("DtprodID"));
/* 139:    */       }
/* 140:142 */       Calendar data3 = Calendar.getInstance();
/* 141:143 */       if (rs.getDate("DtPrefID") != null) {
/* 142:144 */         os.setDtPrefID(rs.getDate("DtPrefID"));
/* 143:    */       }
/* 144:147 */       os.setSolicitadoID(rs.getString("SolicitadoID"));
/* 145:148 */       os.setMotivoID(rs.getString("MotivoID"));
/* 146:149 */       os.setValorCarc(rs.getBigDecimal("ValorCarc"));
/* 147:150 */       os.setDescRef(rs.getBigDecimal("DescRef"));
/* 148:151 */       os.setDescRep(rs.getBigDecimal("DescRep"));
/* 149:152 */       os.setFatRef(rs.getBigDecimal("FatRef"));
/* 150:153 */       os.setFatRep(rs.getBigDecimal("FatRep"));
/* 151:154 */       os.setStEI(rs.getInt("StEI"));
/* 152:155 */       os.setVrCom(rs.getBigDecimal("VrCom"));
/* 153:156 */       os.setLauFDC(rs.getString("LauFDC"));
/* 154:157 */       os.setLauFFC(rs.getString("LauFFC"));
/* 155:    */       
/* 156:159 */       lista.add(os);
/* 157:    */     }
/* 158:161 */     stmt.close();
/* 159:162 */     return lista;
/* 160:    */   }
/* 161:    */   
/* 162:    */   public void atualizar(OS_ERP os)
/* 163:    */     throws ClassNotFoundException, SQLException, Exception
/* 164:    */   {
/* 165:170 */     String sql = "UPDATE OS_ERP SET NrLote = ?, ClienteID = ?, NrMatricula = ?, MedidaID = ?,    MarcaID = ?, ModeloID = ?, StatusID = ?, LRID = ?, VendedorID = ?, ColetadorID = ?,    PrazoID = ?, DtEmisID = ?, DtprodID = ?, DtPrefID = ?, SolicitadoID = ?,    MotivoID = ?, ValorCarc = ?, DescRef = ?, DescRep = ?, FatRef = ?, FatRep = ?,    StEI = ?, VrCom = ?, LauFDC = ?, LauFFC = ? WHERE NrOS = ?";
/* 166:    */     
/* 167:    */ 
/* 168:    */ 
/* 169:    */ 
/* 170:175 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 171:176 */     stmt.setInt(1, os.getNrLote().intValue());
/* 172:177 */     stmt.setString(2, os.getClienteID());
/* 173:178 */     stmt.setString(3, os.getNrMatricula());
/* 174:179 */     stmt.setString(4, os.getMedidaID());
/* 175:180 */     stmt.setString(5, os.getMarcaID());
/* 176:181 */     stmt.setString(6, os.getModeloID());
/* 177:182 */     stmt.setString(7, os.getStatusID());
/* 178:183 */     stmt.setString(8, os.getLRID());
/* 179:184 */     stmt.setString(9, os.getVendedorID());
/* 180:185 */     stmt.setString(10, os.getColetadorID());
/* 181:186 */     stmt.setString(11, os.getPrazoID());
/* 182:187 */     if (os.getDtprodID() != null) {
/* 183:188 */       stmt.setDate(12, new java.sql.Date(os.getDtEmisID().getTime()));
/* 184:    */     } else {
/* 185:190 */       stmt.setDate(12, new java.sql.Date(1L));
/* 186:    */     }
/* 187:193 */     if (os.getDtprodID() != null) {
/* 188:194 */       stmt.setDate(13, new java.sql.Date(os.getDtprodID().getTime()));
/* 189:    */     } else {
/* 190:196 */       stmt.setDate(13, new java.sql.Date(1L));
/* 191:    */     }
/* 192:198 */     if (os.getDtPrefID() != null) {
/* 193:199 */       stmt.setDate(14, new java.sql.Date(os.getDtPrefID().getTime()));
/* 194:    */     } else {
/* 195:201 */       stmt.setDate(14, new java.sql.Date(1L));
/* 196:    */     }
/* 197:203 */     stmt.setString(15, os.getSolicitadoID());
/* 198:204 */     stmt.setString(16, os.getMotivoID());
/* 199:205 */     stmt.setBigDecimal(17, os.getValorCarc());
/* 200:206 */     stmt.setBigDecimal(18, os.getDescRef());
/* 201:207 */     stmt.setBigDecimal(19, os.getDescRep());
/* 202:208 */     stmt.setBigDecimal(20, os.getFatRef());
/* 203:209 */     stmt.setBigDecimal(21, os.getFatRep());
/* 204:210 */     stmt.setInt(22, os.getStEI());
/* 205:211 */     stmt.setBigDecimal(23, os.getVrCom());
/* 206:212 */     stmt.setString(24, os.getLauFDC());
/* 207:213 */     stmt.setString(25, os.getLauFFC());
/* 208:214 */     stmt.setInt(26, os.getNrOS().intValue());
/* 209:215 */     stmt.executeUpdate();
/* 210:216 */     stmt.close();
/* 211:    */   }
/* 212:    */ }


/* Location:           C:\Users\Leonardo\Desktop\INT\InterpSync.jar
 * Qualified Name:     br.com.interpsync.retreadsystem.dao.OS_ERPDAO
 * JD-Core Version:    0.7.0.1
 */