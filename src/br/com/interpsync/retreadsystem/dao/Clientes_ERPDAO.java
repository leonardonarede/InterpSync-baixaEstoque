/*   1:    */ package br.com.interpsync.retreadsystem.dao;
/*   2:    */ 
/*   3:    */ import br.com.interpsync.retreadsystem.jdbc.ConnectionFactory;
/*   4:    */ import br.com.interpsync.retreadsystem.modelo.Clientes_ERP;
/*   5:    */ import java.sql.Connection;
/*   6:    */ import java.sql.PreparedStatement;
/*   7:    */ import java.sql.ResultSet;
/*   8:    */ import java.sql.SQLException;
/*   9:    */ import java.util.ArrayList;
/*  10:    */ import java.util.List;
/*  11:    */ import java.util.logging.Level;
/*  12:    */ import java.util.logging.Logger;
/*  13:    */ 
/*  14:    */ public class Clientes_ERPDAO
/*  15:    */ {
/*  16:    */   private Connection connection;
/*  17:    */   
/*  18:    */   public Clientes_ERPDAO()
/*  19:    */   {
/*  20:    */     try
/*  21:    */     {
/*  22: 29 */       this.connection = ConnectionFactory.getInstance().obterConexao();
/*  23:    */     }
/*  24:    */     catch (SQLException ex)
/*  25:    */     {
/*  26: 31 */       Logger.getLogger(Clientes_ERPDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  27:    */     }
/*  28:    */     catch (ClassNotFoundException ex)
/*  29:    */     {
/*  30: 33 */       Logger.getLogger(Clientes_ERPDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  31:    */     }
/*  32:    */     catch (Exception ex)
/*  33:    */     {
/*  34: 35 */       Logger.getLogger(Clientes_ERPDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  35:    */     }
/*  36:    */   }
/*  37:    */   
/*  38:    */   public Connection getConnection()
/*  39:    */     throws SQLException, ClassNotFoundException, Exception
/*  40:    */   {
/*  41: 43 */     if ((this.connection == null) || (this.connection.isClosed())) {
/*  42: 44 */       this.connection = ConnectionFactory.getInstance().obterConexao();
/*  43:    */     }
/*  44: 46 */     return this.connection;
/*  45:    */   }
/*  46:    */   
/*  47:    */   public List<Clientes_ERP> listar()
/*  48:    */     throws SQLException, ClassNotFoundException, Exception
/*  49:    */   {
/*  50: 53 */     String sql = "SELECT ALL  * FROM CLIENTES_ERP";
/*  51: 54 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/*  52: 55 */     stmt.executeQuery();
/*  53: 56 */     ResultSet rs = stmt.getResultSet();
/*  54: 57 */     List<Clientes_ERP> clientes = new ArrayList();
/*  55: 58 */     while (rs.next())
/*  56:    */     {
/*  57: 59 */       Clientes_ERP cliente = new Clientes_ERP();
/*  58: 60 */       cliente.setCNPJCPF(rs.getString("CNPJCPF"));
/*  59: 61 */       cliente.setNomeCLI(rs.getString("NomeCLI"));
/*  60: 62 */       cliente.setEndeCLI(rs.getString("EndeCLI"));
/*  61: 63 */       cliente.setNrCLI(rs.getString("NrCLI"));
/*  62: 64 */       cliente.setBairroCLI(rs.getString("BairroCLI"));
/*  63: 65 */       cliente.setCidadeCLI(rs.getString("CidadeCLI"));
/*  64: 66 */       cliente.setEstadoCLI(rs.getString("EstadoCLI"));
/*  65: 67 */       cliente.setCepCLI(rs.getString("CepCLI"));
/*  66: 68 */       cliente.setIERGCLI(rs.getString("IERGCLI"));
/*  67: 69 */       cliente.setFJCLI(rs.getString("FJCLI"));
/*  68: 70 */       cliente.setVendR(rs.getString("VendR"));
/*  69: 71 */       cliente.setVendP(rs.getString("VendP"));
/*  70: 72 */       cliente.setVendS(rs.getString("VendS"));
/*  71: 73 */       cliente.setPrazoR(rs.getString("PrazoR"));
/*  72: 74 */       cliente.setPrazoP(rs.getString("PrazoP"));
/*  73: 75 */       cliente.setPrazoS(rs.getString("PrazoS"));
/*  74: 76 */       cliente.setComissaoNF(rs.getBigDecimal("ComissaoNF"));
/*  75: 77 */       cliente.setComissaoTit(rs.getBigDecimal("ComissaoTit"));
/*  76: 78 */       cliente.setRespVencidas(rs.getBigDecimal("RespVencidas"));
/*  77: 79 */       cliente.setRespAVencer(rs.getBigDecimal("RespAVencer"));
/*  78: 80 */       cliente.setCodConceito(rs.getString("CodConceito"));
/*  79: 81 */       cliente.setLimiteCrd(rs.getString("LimiteCrd"));
/*  80: 82 */       cliente.setNContato(rs.getString("NContato"));
/*  81: 83 */       cliente.setTContato(rs.getString("TContato"));
/*  82: 84 */       cliente.setStEI(rs.getInt("StEI"));
/*  83: 85 */       clientes.add(cliente);
/*  84:    */     }
/*  85: 87 */     stmt.close();
/*  86: 88 */     return clientes;
/*  87:    */   }
/*  88:    */   
/*  89:    */   public void inserir(Clientes_ERP cliente)
/*  90:    */     throws SQLException, ClassNotFoundException, Exception
/*  91:    */   {
/*  92: 95 */     String sql = "INSERT INTO CLIENTES_ERP (CNPJCPF, NomeCLI, EndeCLI, NrCLI, BairroCLI, CidadeCLI,    EstadoCLI, CepCLI, IERGCLI, FJCLI, VendR, VendP, VendS, PrazoR, PrazoP,    PrazoS,ComissaoNF, ComissaoTit, RespVencidas, RespAVencer, CodConceito, LimiteCrd, NContato, TContato, StEI)    VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
/*  93:    */     
/*  94:    */ 
/*  95:    */ 
/*  96: 99 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/*  97:100 */     stmt.setString(1, cliente.getCNPJCPF());
/*  98:101 */     stmt.setString(2, cliente.getNomeCLI());
/*  99:102 */     stmt.setString(3, cliente.getEndeCLI());
/* 100:103 */     stmt.setString(4, cliente.getNrCLI());
/* 101:104 */     stmt.setString(5, cliente.getBairroCLI());
/* 102:105 */     stmt.setString(6, cliente.getCidadeCLI());
/* 103:106 */     stmt.setString(7, cliente.getEstadoCLI());
/* 104:107 */     stmt.setString(8, cliente.getCepCLI());
/* 105:108 */     stmt.setString(9, cliente.getIERGCLI());
/* 106:109 */     stmt.setString(10, cliente.getFJCLI());
/* 107:110 */     stmt.setString(11, cliente.getVendR());
/* 108:111 */     stmt.setString(12, cliente.getVendP());
/* 109:112 */     stmt.setString(13, cliente.getVendS());
/* 110:113 */     stmt.setString(14, cliente.getPrazoR());
/* 111:114 */     stmt.setString(15, cliente.getPrazoP());
/* 112:115 */     stmt.setString(16, cliente.getPrazoS());
/* 113:116 */     stmt.setBigDecimal(17, cliente.getComissaoNF());
/* 114:117 */     stmt.setBigDecimal(18, cliente.getComissaoTit());
/* 115:118 */     stmt.setBigDecimal(19, cliente.getRespVencidas());
/* 116:119 */     stmt.setBigDecimal(20, cliente.getRespAVencer());
/* 117:120 */     stmt.setString(21, cliente.getCodConceito());
/* 118:121 */     stmt.setString(22, cliente.getLimiteCrd());
/* 119:122 */     stmt.setString(23, cliente.getNContato());
/* 120:123 */     stmt.setString(24, cliente.getTContato());
/* 121:124 */     stmt.setInt(25, cliente.getStEI());
/* 122:125 */     stmt.executeUpdate();
/* 123:126 */     stmt.close();
/* 124:    */   }
/* 125:    */   
/* 126:    */   public Clientes_ERP findbyid(String id)
/* 127:    */     throws ClassNotFoundException, Exception, SQLException
/* 128:    */   {
/* 129:133 */     String sql = "SELECT * FROM CLIENTES_ERP WHERE CNPJCPF = ?";
/* 130:134 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 131:135 */     stmt.setString(1, id);
/* 132:136 */     stmt.executeQuery();
/* 133:137 */     ResultSet rs = stmt.getResultSet();
/* 134:138 */     Clientes_ERP cliente = new Clientes_ERP();
/* 135:139 */     if (rs.next())
/* 136:    */     {
/* 137:140 */       cliente.setCNPJCPF(rs.getString("CNPJCPF"));
/* 138:141 */       cliente.setNomeCLI(rs.getString("NomeCLI"));
/* 139:142 */       cliente.setEndeCLI(rs.getString("EndeCLI"));
/* 140:143 */       cliente.setNrCLI(rs.getString("NrCLI"));
/* 141:144 */       cliente.setBairroCLI(rs.getString("BairroCLI"));
/* 142:145 */       cliente.setCidadeCLI(rs.getString("CidadeCLI"));
/* 143:146 */       cliente.setEstadoCLI(rs.getString("EstadoCLI"));
/* 144:147 */       cliente.setCepCLI(rs.getString("CepCLI"));
/* 145:148 */       cliente.setIERGCLI(rs.getString("IERGCLI"));
/* 146:149 */       cliente.setFJCLI(rs.getString("FJCLI"));
/* 147:150 */       cliente.setVendR(rs.getString("VendR"));
/* 148:151 */       cliente.setVendP(rs.getString("VendP"));
/* 149:152 */       cliente.setVendS(rs.getString("VendS"));
/* 150:153 */       cliente.setPrazoR(rs.getString("PrazoR"));
/* 151:154 */       cliente.setPrazoP(rs.getString("PrazoP"));
/* 152:155 */       cliente.setPrazoS(rs.getString("PrazoS"));
/* 153:156 */       cliente.setComissaoNF(rs.getBigDecimal("ComissaoNF"));
/* 154:157 */       cliente.setComissaoTit(rs.getBigDecimal("ComissaoTit"));
/* 155:158 */       cliente.setRespVencidas(rs.getBigDecimal("RespVencidas"));
/* 156:159 */       cliente.setRespAVencer(rs.getBigDecimal("RespAVencer"));
/* 157:160 */       cliente.setCodConceito(rs.getString("CodConceito"));
/* 158:161 */       cliente.setLimiteCrd(rs.getString("LimiteCrd"));
/* 159:162 */       cliente.setNContato(rs.getString("NContato"));
/* 160:163 */       cliente.setTContato(rs.getString("TContato"));
/* 161:164 */       cliente.setStEI(rs.getInt("StEI"));
/* 162:    */     }
/* 163:166 */     stmt.close();
/* 164:167 */     return cliente;
/* 165:    */   }
/* 166:    */   
/* 167:    */   public void atualizar(Clientes_ERP cliente)
/* 168:    */     throws SQLException, ClassNotFoundException, Exception
/* 169:    */   {
/* 170:175 */     String sql = "UPDATE CLIENTES_ERP SET NomeCLI = ?, EndeCLI = ?, NrCLI = ?, BairroCLI = ?, CidadeCLI = ?,    EstadoCLI = ?, CepCLI = ?, IERGCLI = ?, FJCLI = ?, VendR = ?, VendP = ?, VendS = ?, PrazoR = ?, PrazoP = ?,    PrazoS = ?,ComissaoNF = ?, ComissaoTit = ?, RespVencidas = ?, RespAVencer = ?, CodConceito = ?,    LimiteCrd = ?, NContato = ?, TContato = ?, StEI = ? WHERE CNPJCPF = ?";
/* 171:    */     
/* 172:    */ 
/* 173:    */ 
/* 174:179 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 175:180 */     stmt.setString(1, cliente.getNomeCLI());
/* 176:181 */     stmt.setString(2, cliente.getEndeCLI());
/* 177:182 */     stmt.setString(3, cliente.getNrCLI());
/* 178:183 */     stmt.setString(4, cliente.getBairroCLI());
/* 179:184 */     stmt.setString(5, cliente.getCidadeCLI());
/* 180:185 */     stmt.setString(6, cliente.getEstadoCLI());
/* 181:186 */     stmt.setString(7, cliente.getCepCLI());
/* 182:187 */     stmt.setString(8, cliente.getIERGCLI());
/* 183:188 */     stmt.setString(9, cliente.getFJCLI());
/* 184:189 */     stmt.setString(10, cliente.getVendR());
/* 185:190 */     stmt.setString(11, cliente.getVendP());
/* 186:191 */     stmt.setString(12, cliente.getVendS());
/* 187:192 */     stmt.setString(13, cliente.getPrazoR());
/* 188:193 */     stmt.setString(14, cliente.getPrazoP());
/* 189:194 */     stmt.setString(15, cliente.getPrazoS());
/* 190:195 */     stmt.setBigDecimal(16, cliente.getComissaoNF());
/* 191:196 */     stmt.setBigDecimal(17, cliente.getComissaoTit());
/* 192:197 */     stmt.setBigDecimal(18, cliente.getRespVencidas());
/* 193:198 */     stmt.setBigDecimal(19, cliente.getRespAVencer());
/* 194:199 */     stmt.setString(20, cliente.getCodConceito());
/* 195:200 */     stmt.setString(21, cliente.getLimiteCrd());
/* 196:201 */     stmt.setString(22, cliente.getNContato());
/* 197:202 */     stmt.setString(23, cliente.getTContato());
/* 198:203 */     stmt.setInt(24, cliente.getStEI());
/* 199:204 */     stmt.setString(25, cliente.getCNPJCPF());
/* 200:205 */     stmt.executeUpdate();
/* 201:206 */     stmt.close();
/* 202:    */   }
/* 203:    */ }


/* Location:           C:\Users\Leonardo\Desktop\INT\InterpSync.jar
 * Qualified Name:     br.com.interpsync.retreadsystem.dao.Clientes_ERPDAO
 * JD-Core Version:    0.7.0.1
 */