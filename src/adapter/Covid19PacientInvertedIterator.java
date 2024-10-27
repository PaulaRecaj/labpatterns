package adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import domain.Covid19Pacient;
import domain.Symptom;

public class Covid19PacientInvertedIterator implements InvertedIterator{
	private List<Symptom> symptoms = new ArrayList<>();
	private int position;
	
	public Covid19PacientInvertedIterator(Covid19Pacient pacient) {
		Set<Symptom> symptomSet = pacient.getSymptoms();
		symptoms.addAll(symptomSet);
		goLast();
	}
	
	@Override
	public Object previous() {
		return symptoms.get(position--);
	}
	
	@Override
	public boolean hasPrevious() {
		return position>=0;
	}
	
	@Override
	public void goLast() {
		position = symptoms.size()-1;
	}
}
