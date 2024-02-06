package tools;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Display {
	public static void print(String content) {
		System.out.println(content);
	}
	public static void printWS(String content) {
		// print content with a white space line at the bottom
		System.out.println(content);
		System.out.println("");
	}
	public static String printCol(String key, String value) {
		return "";
	}
	public static int maxLength(ArrayList<String> list) {
		int max = 0;
		for (String el:list) {
			if (el.length() > max) {
				max = el.length();
			}
		}
		return max;
	}
	public static String centerStringContent(int availableSpace, String content) {
		String newContent = content;
		int freeSpace = availableSpace - content.length();
		if(freeSpace <= 0) {
			freeSpace = 0;
			int endIndex = availableSpace - Math.abs(freeSpace) - 3;
			newContent = content.substring(0, endIndex >= 0? endIndex: 0) + "...";
		}
		String space = " ".repeat((int)(Math.round(freeSpace/2)));
		int totalOccupiedSpace = ((space.length() * 2 ) + newContent.length());
		int missingSpace = 0;
		if (availableSpace - totalOccupiedSpace > 0) {
			missingSpace = availableSpace - totalOccupiedSpace;
		} 
		return space + newContent + " ".repeat(missingSpace) + space;
	}
	public static void printHeader(String value) {
		System.out.println("");
		System.out.println("------  "+ value + "  ------");
		System.out.println("");
	}
	public static void print(String value, int indentation ) {
		System.out.println(printIndentation(indentation) + value);
	}
	public static void print(int value, int indentation ) {
		System.out.println(printIndentation(indentation) + value);
	}
	public static void print(Double value, int indentation ) {
		System.out.println(printIndentation(indentation) + value);
	}
	public static void print(int value) {
		System.out.println(value);
	}
	public static void print(double value) {
		System.out.println(value);
	}

	public static String printCol(String key, String value, boolean isComma) {
		return key + " : " + value + (isComma?", ": "  ");
	}
	public static String printCol(String key, int value, boolean isComma) {
		return key + " : " + value + (isComma?", ": "  ");
	}
	public static String printCol(String key, Double value, boolean isComma) {
		return  key + " : " + value + (isComma?", ": "  ");
	}
	public static String printCol(String key, String value, String fancies) {
		return  fancies + " " + key + " : " + value + " " + fancies;
	}
	public static String printCol(String value, String fancies, int space) {
		return fancies + Display.centerStringContent(space, value) + fancies;
	}
	public static String printCol(int value, String fancies, int space) {
		return fancies + Display.centerStringContent(space, value + "") + fancies;
	}
	public static String printCol(Double value, String fancies, int space) {
		return fancies + Display.centerStringContent(space, value + "") + fancies;
	}
	public static String printTabHeader(Field[] fields, int colWidth) {
		//methode retournant une chaine de charactères et permet de display une entete de tableau grace aux noms de colonnes reçuent sous forme de tableau 
		String yHeader = "";
		String headerNames = "";

		for(Field field:fields) {
			String top = "-".repeat(colWidth - 2);
			yHeader += "+" + top + "";
			headerNames += "|" + Display.centerStringContent(colWidth - 2, field.getName().toString());
		}
		return yHeader + "+\n" +
				headerNames + "|\n" +
				yHeader + ""; 		
	}
	public static <T> void printTableHeader(T obj, int colWidth) {
		//@params T object
		//@params int colWidth
		//@return void
		// methode d'affichage recupérant les attributs d'une classe générqiue sous forme de tableau pour les passer à printTabHeader
		// on réucupère la classe de l'objet pour récupérer ces attributs
		 Class<?> c = obj.getClass();
		 Field[] fields = c.getDeclaredFields();
		 //une fois récupérer les champs (contenant leurs noms, leurs valeurs, methodes même les constructeurs) on utilise la méthode de mise en affichage et on affiche
		Display.print(printTabHeader(fields, colWidth));
		
	}
	public static <T> int countObjectFields(T obj) {
		//@params T obj 
		// return integer
		// methode retounant le nombre d'attributs de la classe passé en paramètre
		 Class<?> c = obj.getClass();
		 return c.getDeclaredFields().length;
	}
	public static String printIndentation(int level) {
		//@params int level
		//@return String 
		//retourne une chaine de characteres équivalennt à une tabulation, le nombre de tabulation se gère avec le level
		int i = 0;
		String str = "";
		while(i < level) {
			str += "    ";
			i++;
		}
		return str;
	}
	
	public static void printSimpleTable(String key, String value, int colWidth) {
		// @params String key
		//@params String value
		// @params int colWidth
		// methode d'affichage pour une simple clé /valeur, paramétrage de la largeur de colonne avec un integer 
		String yHeader = "";
		String headerNames = "";

		String top = "-".repeat(colWidth - 2);
		yHeader += "+" + top + "+" + top + "+";
		headerNames = "|" + Display.centerStringContent(colWidth -2, key) + "|" + Display.centerStringContent(colWidth - 2, value) + "|";
		
		Display.print(yHeader + "\n" +
				headerNames + "\n" +
				yHeader + ""); 
	}
	
	public static <T> void printTable(List<T> list, int colWidth, String title) {
		// @params list : ArrayList d'objets generic
		// @ params colWidth : integer de largeur de colonne fixe pour chaque proprietés
		// @ params title : titre du tableau  
		
		// placement dans l'espace du titre du tableau
		if(list.size() > 0) {
			int totalSpace = countObjectFields(list.get(0)) * colWidth;
			Display.print(centerStringContent(totalSpace, title));
			//affichage du header du tableau, on passe le premier objet pour récupérer les champs
			printTableHeader(list.get(0), colWidth);
			//affichage des lignes du tableau avec les valeurs du tableau d'objets
			for(T obj: list) {
				 Class<?> c = obj.getClass();
				 Field[] fields = c.getDeclaredFields(); 
				 String rowValues = "";
				 String yRowValues = "";
				 // contruction de chaine de characteres pour chaque ligne des colonnes contenant les valeurs de l'objet (on rend chaque attribut accessible pour permettre la lecture) 
				 for( Field field : fields ){
					 //try catch pour éviter qu'un field (champs /attribut) ne soit pas présent sur l'objet en renvoyant une érreur)
				      try {	
				    	  field.setAccessible(true);
				    	  // chaque valeur de colonne est centré avec la méthode centerStringContent
				    	  if(isBooleanProperty(field.getName())) {
				    		  rowValues += "|" + Display.centerStringContent(colWidth - 2, parseBooleanProperty(field.get(obj) + "",field.getName()) + "");
				    	  } else {
				    		  rowValues += "|" + Display.centerStringContent(colWidth - 2, field.get(obj) + "");
				    	  }
				    	  
				    	  // on ajoute des tirets du 6 entre chaque ligne et  un + pour démarquer chaque colonne
				    	  String bottom = "-".repeat(colWidth - 2);
				    	  yRowValues += "+" + bottom + "";
				      } catch (IllegalArgumentException e1) {
				    	  Display.print(e1 +"");
				      } catch (IllegalAccessException e1) {
				    	  Display.print(e1 +"");
				      }
				 }

				 System.out.println(rowValues + "|");
				 System.out.println(yRowValues + "+");
			}
		}else {
			Display.print("Rien trouvé pour "+title+"!" );
		}
	}
	public static <T> void printTable(List<T> list, int colWidth, String title, String direction) {
		// @ params List<T> list : ArrayList d'objets generiques
		// @ params Integer colWidth : integer de definition de  largeur des colonnes pour chaque proprietés/valeurs
		// @ params String title : titre du tableau  
		// @ params String direction : 'horizontal' => première colonne pour les noms des champs; 'autres' => les noms des champs en premère ligne
		
		if(direction.equals("horizontal")) {
			if(list.size()> 0) {
				// 1 ere colonne fieldName puis chaque colonne par objet
				int columnsNumber = list.size() + 1;
				String yHeader = "";
				String headerNames = "";
				int totalSpace = (list.size()+1) * colWidth;
				Display.print(centerStringContent(totalSpace, title));
				Class<?> c = list.get(0).getClass();
				Field[] fields = c.getDeclaredFields(); 
				for(Field field: fields) {
					// ----------------------------Premiere colonne : nom des champs -------------
					String top = "-".repeat(colWidth - 1);
					yHeader += "+" + top;
					headerNames += "|" + Display.centerStringContent(colWidth -1, field.getName());
					//----------------------------------------------------------------
					for(T obj: list) {
						// pour chaque objet, une colonne supplémentaire est ajoutée
						String topObj= "";
						topObj += "-".repeat(colWidth - 1);
						yHeader += "+" +topObj ;
						try {
							//l'accés aux attributs se faisant directement (sans passer par les getters), nous devons changer la visibilité de l'attribut en cours à public 
						field.setAccessible(true);
						// On check si le nom de l'attribut fait partie d'une liste d'attributs booleans qu'il faut parser en texte pour donner du sens  
				    	  if(isBooleanProperty(field.getName())) {
				    		  headerNames += "|" + Display.centerStringContent(colWidth - 1, parseBooleanProperty(field.get(obj) + "",field.getName()) + "");
				    	  } else {
				    		  headerNames += "|" + Display.centerStringContent(colWidth - 1, field.get(obj) + "");
				    	  }	
						} catch (IllegalArgumentException e1) {
					    	  Display.print(e1 +"");
					    } catch (IllegalAccessException e1) {
					    	  Display.print(e1 +"");
					    }				
					}
					// afichage des variables qui concat le nom de l'attribut puis les valeurs de chaque objets de la liste objet
					// on affiche chaque ligne à la fin d'un tour de boucle (des attributs) 
					Display.print(yHeader + "+\n" +
							headerNames + "|"
							);
					top = "";
					yHeader = "";
					headerNames = "";
				}
				Display.print(("+" +"-".repeat(colWidth -1)).repeat(columnsNumber) + "+");
			}else {
				// tableau vide
				Display.print("Rien trouvé pour "+title+" !" );
			}
			
		}else {
			if(list.size() > 0) {
				// définition de la largeur totale du tableau pour pouvoir centrer du contenu
				int totalSpace = countObjectFields(list.get(0)) * colWidth;
				// placement dans l'espace du titre du tableau grâce à la largeur totale
				Display.print(centerStringContent(totalSpace, title));
				//affichage du header du tableau, on passe le premier objet pour récupérer les noms des attributs
				printTableHeader(list.get(0), colWidth);
				//affichage des lignes du tableau avec les valeurs du tableau d'objets
				for(T obj: list) {
					 Class<?> c = obj.getClass();
					 Field[] fields = c.getDeclaredFields(); 
					 String rowValues = "";
					 String yRowValues = "";
					 // contruction de chaine de characteres pour chaque ligne des colonnes contenant les valeurs de l'objet (on rend chaque attribut accessible pour permettre la lecture) 
					 for( Field field : fields ){
						 //try catch pour éviter qu'un field (champs /attribut) ne soit pas présent sur l'objet en renvoyant une érreur)
					      try {	
					    	  field.setAccessible(true);
					    	  // chaque valeur de colonne est centré avec la méthode centerStringContent
					    	  if(isBooleanProperty(field.getName())) {
					    		  rowValues += "|" + Display.centerStringContent(colWidth - 2, parseBooleanProperty(field.get(obj) + "",field.getName()) + "");
					    	  } else {
					    		  rowValues += "|" + Display.centerStringContent(colWidth - 2, field.get(obj) + "");
					    	  }
					    	  
					    	  // on ajoute des tirets du 6 entre chaque ligne et  un + pour démarquer chaque colonne
					    	  String bottom = "-".repeat(colWidth - 2);
					    	  yRowValues += "+" + bottom + "";
					      } catch (IllegalArgumentException e1) {
					    	  Display.print(e1 +"");
					      } catch (IllegalAccessException e1) {
					    	  Display.print(e1 +"");
					      }
					 }
					 // affichage d'une ligne de valeurs suivie par une ligne de séparation horizontale
					 System.out.println(rowValues + "|");
					 System.out.println(yRowValues + "+");
				}
			}else {
				Display.print("Rien trouvé pour "+title+" !" );
			}
		}
	}
	public static <T> void printTable(T obj, int colWidth, String title) {
		// @params obj : objet generic
		// @ params colWidth : integer de largeur de colonne fixe pour chaque proprietés
		// @ params title : titre du tableau  
		
		// placement dans l'espace du titre du tableau
		int totalSpace = countObjectFields(obj) * colWidth;
		Display.print(centerStringContent(totalSpace, title));
		//affichage du header du tableau, on passe le premier objet pour récupérer les champs
		printTableHeader(obj, colWidth);
		Class<?> c = obj.getClass();
		Field[] fields = c.getDeclaredFields(); 
		String rowValues = "";
		String yRowValues = "";
		 // contruction de chaine de characteres pour chaque ligne des colonnes contenant les valeurs de l'objet (on rend chaque attribut accessible pour permettre la lecture) 
		for( Field field : fields ){
			 //try catch pour éviter qu'un field (champs /attribut) ne soit pas présent sur l'objet en renvoyant une érreur)
		      try {	
		    	  field.setAccessible(true);
		    	  // chaque valeur de colonne est centré avec la méthode centerStringContent
		    	  if(isBooleanProperty(field.getName())) {
		    		  rowValues += "|" + Display.centerStringContent(colWidth - 2, parseBooleanProperty(field.get(obj) + "",field.getName()) + "");
		    	  } else {
		    		  rowValues += "|" + Display.centerStringContent(colWidth - 2, field.get(obj) + "");
		    	  }
		    	  
		    	  // on ajoute des tirets du 6 entre chaque ligne et  un + pour démarquer chaque colonne
		    	  String bottom = "-".repeat(colWidth - 2);
		    	  yRowValues += "+" + bottom + "";
		      } catch (IllegalArgumentException e1) {
		    	  Display.print(e1 +"");
		      } catch (IllegalAccessException e1) {
		    	  Display.print(e1 +"");
		      }
		 }

		 System.out.println(rowValues + "|");
		 System.out.println(yRowValues + "+");
		
	}
	public static boolean isBooleanProperty(String fieldName) {
		List<String> yesOrNoS = Arrays.asList("parking", "wifi", "piscine","navette", "animaux", "categorie","sdbP","tv","balcon","fridge","baignoire","insonorisation");
		return yesOrNoS.contains(fieldName); 
	}
	public static String parseBooleanProperty(String value, String fieldName) {
		int val = Integer.parseInt(value);
		List<String> yesOrNoS = Arrays.asList("parking", "wifi", "piscine","navette","sdbP","tv","balcon","fridge","baignoire","insonorisation");
		String displayedName = "";
		if(yesOrNoS.contains(fieldName)) {
			if(val == 0) {
				displayedName = "Non";
			} else if(val == 1) {
				displayedName = "Oui";
			}
		}
		if(fieldName.equals("animaux")) {
			if(val == 0) {
				displayedName = "Non";
			} else if(val == 1) {
				displayedName = "Admis";
			}
		}
		if(fieldName.equals("categorie")) {
			displayedName = "*".repeat(val);
		}
		
		return displayedName;
	}
}
