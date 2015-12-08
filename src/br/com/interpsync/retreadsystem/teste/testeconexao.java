/*  1:   */ package br.com.interpsync.retreadsystem.teste;
/*  2:   */ 
/*  3:   */ import br.com.interpsync.retreadsystem.dao.Vendedores_ERPDAO;
/*  4:   */ import br.com.interpsync.retreadsystem.modelo.Vendedores_ERP;
/*  5:   */ import java.io.PrintStream;
/*  6:   */ import java.sql.SQLException;
/*  7:   */ import java.text.ParseException;
/*  8:   */ 
/*  9:   */ public class testeconexao
/* 10:   */ {
/* 11:   */   public static void main(String[] args)
/* 12:   */     throws SQLException, ParseException, ClassNotFoundException, Exception
/* 13:   */   {
/* 14:18 */     Vendedores_ERPDAO dao = new Vendedores_ERPDAO();
/* 15:19 */     for (Vendedores_ERP vendedor : dao.listar()) {
/* 16:20 */       System.out.println("Cod: " + vendedor.getCodVE() + " Nome: " + vendedor.getNomeVE());
/* 17:   */     }
/* 18:   */   }
/* 19:   */ }


/* Location:           C:\Users\Leonardo\Desktop\INT\InterpSync.jar
 * Qualified Name:     br.com.interpsync.retreadsystem.teste.testeconexao
 * JD-Core Version:    0.7.0.1
 */