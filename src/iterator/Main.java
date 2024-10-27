package iterator;

import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import adapter.Covid19PacientInvertedIterator;
import adapter.Sorting;
import domain.Covid19Pacient;
import domain.Symptom;

	public class Main {

		public static void main(String[] args) {
			// Crear un paciente con cinco sintomas
			Covid19Pacient p=new Covid19Pacient("Ane", 29);
			p.addSymptom(new Symptom("tos seca", 5, 3), 3);
			p.addSymptom(new Symptom("fiebre", 5, 5), 2);
			p.addSymptom(new Symptom("dolor de garganta", 3, 2), 4);
			p.addSymptom(new Symptom("disnea", 3, 4), 1);
			p.addSymptom(new Symptom("cefalea", 3, 1), 5);
			
			// Adaptador de Covid19Pacient a InvertedIterator
			Covid19PacientInvertedIterator invertedIterator = new Covid19PacientInvertedIterator(p);
			
			// Ordenar e imprimir por symptomName
			// Expected result: cefalea, disnea, dolor de garganta, fiebre, tos seca
			System.out.println("Síntomas ordenados por symptomName:");
			Iterator<Object> sortedByName = Sorting.sortedIterator(invertedIterator, new SymptomNameComparator());
			while (sortedByName.hasNext()) {
				System.out.println(sortedByName.next());
			}
			
			System.out.println();

			// Ordenar e imprimir por severityIndex
			// Expected result: cefalea, dolor de garganta, tos seca, disnea, fiebre
			System.out.println("Síntomas ordenados por severityIndex:");
			Iterator<Object> sortedBySeverity = Sorting.sortedIterator(invertedIterator, new SeverityIndexComparator());
			while (sortedBySeverity.hasNext()) {
				System.out.println(sortedBySeverity.next());
			}
		}

	}

