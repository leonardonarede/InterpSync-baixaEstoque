/*   1:    */ package br.com.interpsync.retreadsystem.dao;
/*   2:    */ 
/*   3:    */ import br.com.interpsync.retreadsystem.jdbc.ConnectionFactory;
/*   4:    */ import br.com.interpsync.retreadsystem.modelo.Vendedores_ERP;
/*   5:    */ import java.sql.Connection;
/*   6:    */ import java.sql.PreparedStatement;
/*   7:    */ import java.sql.ResultSet;
/*   8:    */ import java.sql.SQLException;
/*   9:    */ import java.util.ArrayList;
/*  10:    */ import java.util.List;
/*  11:    */ import java.util.logging.Level;
/*  12:    */ import java.util.logging.Logger;
/*  13:    */ 
/*  14:    */ public class Vendedores_ERPDAO
/*  15:    */ {
/*  16:    */   private Connection connection;
/*  17:    */   
/*  18:    */   public Vendedores_ERPDAO()
/*  19:    */   {
/*  20:    */     try
/*  21:    */     {
/*  22: 27 */       this.connection = ConnectionFactory.getInstance().obterConexao();
/*  23:    */     }
/*  24:    */     catch (SQLException ex)
/*  25:    */     {
/*  26: 29 */       Logger.getLogger(Vendedores_ERPDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  27:    */     }
/*  28:    */     catch (ClassNotFoundException ex)
/*  29:    */     {
/*  30: 31 */       Logger.getLogger(Vendedores_ERPDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  31:    */     }
/*  32:    */     catch (Exception ex)
/*  33:    */     {
/*  34: 33 */       Logger.getLogger(Vendedores_ERPDAO.class.getName()).log(Level.SEVERE, null, ex);
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
/*  47:    */   public List<Vendedores_ERP> listarTodos()
/*  48:    */     throws SQLException, ClassNotFoundException, Exception
/*  49:    */   {
/*  50: 51 */     String sql = "SELECT ALL * FROM VENDEDORES_ERP";
/*  51: 52 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/*  52: 53 */     stmt.executeQuery();
/*  53: 54 */     ResultSet rs = stmt.getResultSet();
/*  54: 55 */     List<Vendedores_ERP> vendedores = new ArrayList();
/*  55: 56 */     while (rs.next())
/*  56:    */     {
/*  57: 57 */       Vendedores_ERP vendedor = new Vendedores_ERP();
/*  58: 58 */       vendedor.setCodVE(rs.getString("CodVE"));
/*  59: 59 */       vendedor.setNomeVE(rs.getString("NomeVE"));
/*  60: 60 */       vendedor.setRegiaoVE(rs.getString("RegiaoVE"));
/*  61: 61 */       vendedor.setStEI(rs.getInt("StEI"));
/*  62: 62 */       vendedores.add(vendedor);
/*  63:    */     }
/*  64: 64 */     stmt.close();
/*  65: 65 */     return vendedores;
/*  66:    */   }
/*  67:    */   
/*  68:    */   public List<Vendedores_ERP> listar()
/*  69:    */     throws SQLException, ClassNotFoundException, Exception
/*  70:    */   {
/*  71: 72 */     String sql = "SELECT ALL * FROM VENDEDORES_ERP";
/*  72: 73 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/*  73: 74 */     stmt.executeQuery();
/*  74: 75 */     ResultSet rs = stmt.getResultSet();
/*  75: 76 */     List<Vendedores_ERP> vendedores = new ArrayList();
/*  76: 77 */     while (rs.next())
/*  77:    */     {
/*  78: 78 */       Vendedores_ERP vendedor = new Vendedores_ERP();
/*  79: 79 */       vendedor.setCodVE(rs.getString("CodVE"));
/*  80: 80 */       vendedor.setNomeVE(rs.getString("NomeVE"));
/*  81: 81 */       vendedor.setRegiaoVE(rs.getString("RegiaoVE"));
/*  82: 82 */       vendedor.setStEI(rs.getInt("StEI"));
/*  83: 83 */       vendedores.add(vendedor);
/*  84:    */     }
/*  85: 85 */     stmt.close();
/*  86: 86 */     return vendedores;
/*  87:    */   }
/*  88:    */   
/*  89:    */   public void inserir(Vendedores_ERP vendedor)
/*  90:    */     throws SQLException, ClassNotFoundException, Exception
/*  91:    */   {
/*  92: 93 */     String sql = "INSERT INTO VENDEDORES_ERP (CodVE, NomeVE, RegiaoVE, StEI)    VALUES (?, ?, ?, ?)";
/*  93:    */     
/*  94: 95 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/*  95: 96 */     stmt.setString(1, vendedor.getCodVE());
/*  96: 97 */     stmt.setString(2, vendedor.getNomeVE());
/*  97: 98 */     stmt.setString(3, vendedor.getRegiaoVE());
/*  98: 99 */     stmt.setInt(4, vendedor.getStEI());
/*  99:100 */     stmt.executeUpdate();
/* 100:101 */     stmt.close();
/* 101:    */   }
/* 102:    */   
/* 103:    */   public Vendedores_ERP findById(String id)
/* 104:    */     throws SQLException, ClassNotFoundException, Exception
/* 105:    */   {
/* 106:108 */     String sql = "SELECT CodVE, NomeVE, RegiaoVE, StEI FROM VENDEDORES_ERP WHERE CodVE = ?";
/* 107:109 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 108:110 */     stmt.setString(1, id);
/* 109:111 */     ResultSet rs = stmt.executeQuery();
/* 110:112 */     stmt.close();
/* 111:113 */     return null;
/* 112:    */   }
/* 113:    */ }


/* Location:           C:\Users\Leonardo\Desktop\INT\InterpSync.jar
 * Qualified Name:     br.com.interpsync.retreadsystem.dao.Vendedores_ERPDAO
 * JD-Core Version:    0.7.0.1
 */