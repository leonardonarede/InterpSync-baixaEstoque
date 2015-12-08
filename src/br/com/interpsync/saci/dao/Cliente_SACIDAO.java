/*   1:    */ package br.com.interpsync.saci.dao;
/*   2:    */ 
/*   3:    */ import br.com.interpsync.saci.jdbc.ConnectionFactorySACI;
/*   4:    */ import br.com.interpsync.saci.modelo.Cliente_SACI;
/*   5:    */ import java.sql.Connection;
/*   6:    */ import java.sql.PreparedStatement;
/*   7:    */ import java.sql.ResultSet;
/*   8:    */ import java.sql.SQLException;
/*   9:    */ import java.util.ArrayList;
/*  10:    */ import java.util.List;
/*  11:    */ import java.util.logging.Level;
/*  12:    */ import java.util.logging.Logger;
/*  13:    */ 
/*  14:    */ public class Cliente_SACIDAO
/*  15:    */ {
/*  16:    */   private Connection conexao;
/*  17:    */   
/*  18:    */   public Cliente_SACIDAO()
/*  19:    */   {
/*  20:    */     try
/*  21:    */     {
/*  22: 27 */       this.conexao = ConnectionFactorySACI.getInstance().obterConexao();
/*  23:    */     }
/*  24:    */     catch (SQLException ex)
/*  25:    */     {
/*  26: 29 */       Logger.getLogger(Cliente_SACIDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  27:    */     }
/*  28:    */     catch (ClassNotFoundException ex)
/*  29:    */     {
/*  30: 31 */       Logger.getLogger(Cliente_SACIDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  31:    */     }
/*  32:    */     catch (Exception ex)
/*  33:    */     {
/*  34: 33 */       Logger.getLogger(Cliente_SACIDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  35:    */     }
/*  36:    */   }
/*  37:    */   
/*  38:    */   public Connection getConnection()
/*  39:    */     throws SQLException, ClassNotFoundException, Exception
/*  40:    */   {
/*  41: 41 */     if ((this.conexao == null) || (this.conexao.isClosed())) {
/*  42: 42 */       this.conexao = ConnectionFactorySACI.getInstance().obterConexao();
/*  43:    */     }
/*  44: 44 */     return this.conexao;
/*  45:    */   }
/*  46:    */   
/*  47:    */   public List<Cliente_SACI> listar()
/*  48:    */     throws SQLException, ClassNotFoundException, Exception
/*  49:    */   {
/*  50: 51 */     String sql = "SELECT custp.cpf_cgc  , custp.name , custp.add1 , custp.nei1 , custp.city1 , custp.state1 , custp.zip , fjflag , salesperson , brthplace_insc , IFNULL(custp.crlimit,0)/100 crlimit FROM   custp  WHERE  (custp.no <> '100001') AND    (custp.nei1 <> '')  AND    (MID(custp.zip,1,9) > 0)  AND    (custp.sincedt = DATE_FORMAT(CURDATE(),'%Y%m%d')) GROUP BY 1 ORDER BY 1 DESC";
/*  51:    */     
/*  52:    */ 
/*  53:    */ 
/*  54:    */ 
/*  55:    */ 
/*  56:    */ 
/*  57:    */ 
/*  58:    */ 
/*  59:    */ 
/*  60:    */ 
/*  61:    */ 
/*  62:    */ 
/*  63:    */ 
/*  64:    */ 
/*  65:    */ 
/*  66:    */ 
/*  67:    */ 
/*  68: 69 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/*  69: 70 */     stmt.executeQuery();
/*  70: 71 */     ResultSet rs = stmt.getResultSet();
/*  71: 72 */     List<Cliente_SACI> clientes = new ArrayList();
/*  72: 73 */     while (rs.next())
/*  73:    */     {
/*  74: 74 */       Cliente_SACI cliente = new Cliente_SACI();
/*  75: 75 */       cliente.setCpf_cgc(rs.getString("cpf_cgc"));
/*  76: 76 */       cliente.setName(rs.getString("name"));
/*  77: 77 */       cliente.setAdd1(rs.getString("add1"));
/*  78: 78 */       cliente.setNei1(rs.getString("nei1"));
/*  79: 79 */       cliente.setCity1(rs.getString("city1"));
/*  80: 80 */       cliente.setState1(rs.getString("state1"));
/*  81: 81 */       cliente.setZip(rs.getString("zip"));
/*  82: 82 */       cliente.setFjflag(rs.getString("fjflag"));
/*  83: 83 */       cliente.setSalesperson(rs.getString("salesperson"));
/*  84: 84 */       cliente.setCrlimit(rs.getBigDecimal("crlimit"));
/*  85: 85 */       cliente.setBrthplace_insc(rs.getString("brthplace_insc"));
/*  86: 86 */       clientes.add(cliente);
/*  87:    */     }
/*  88: 88 */     stmt.close();
/*  89: 89 */     return clientes;
/*  90:    */   }
/*  91:    */   
/*  92:    */   public Cliente_SACI buscarCl(String cgc)
/*  93:    */     throws ClassNotFoundException, SQLException, Exception
/*  94:    */   {
/*  95: 96 */     String sql = "SELECT * FROM custp WHERE cpf_cgc = ? ";
/*  96: 97 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/*  97: 98 */     stmt.setString(1, cgc);
/*  98: 99 */     stmt.executeQuery();
/*  99:100 */     ResultSet rs = stmt.getResultSet();
/* 100:101 */     Cliente_SACI cliente = new Cliente_SACI();
/* 101:102 */     if ((rs.next()) && 
/* 102:103 */       (rs.findColumn("name") > 0))
/* 103:    */     {
/* 104:104 */       cliente.setNo(Integer.valueOf(rs.getInt("no")));
/* 105:105 */       cliente.setCpf_cgc(rs.getString("cpf_cgc"));
/* 106:106 */       cliente.setName(rs.getString("name"));
/* 107:107 */       cliente.setAdd1(rs.getString("add1"));
/* 108:108 */       cliente.setNei1(rs.getString("nei1"));
/* 109:109 */       cliente.setCity1(rs.getString("city1"));
/* 110:110 */       cliente.setState1(rs.getString("state1"));
/* 111:111 */       cliente.setZip(rs.getString("zip"));
/* 112:112 */       cliente.setFjflag(rs.getString("fjflag"));
/* 113:113 */       cliente.setSalesperson(rs.getString("salesperson"));
/* 114:114 */       cliente.setCrlimit(rs.getBigDecimal("crlimit"));
/* 115:115 */       cliente.setBrthplace_insc(rs.getString("brthplace_insc"));
/* 116:    */     }
/* 117:118 */     return cliente;
/* 118:    */   }
/* 119:    */ }


/* Location:           C:\Users\Leonardo\Desktop\INT\InterpSync.jar
 * Qualified Name:     br.com.interpsync.saci.dao.Cliente_SACIDAO
 * JD-Core Version:    0.7.0.1
 */