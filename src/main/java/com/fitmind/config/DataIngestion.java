package com.fitmind.config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.fitmind.entity.Activity;
import com.fitmind.entity.Workout;
import com.fitmind.entity.enums.ProfileType;
import com.fitmind.repository.ActivityRepository;
//activityRepository;
import com.fitmind.repository.WorkoutRepository;

@Configuration
@Profile("Ingestion")
public class DataIngestion implements CommandLineRunner {

	private WorkoutRepository workoutRepository;
	private ActivityRepository activityRepository;

	public DataIngestion(WorkoutRepository workoutRepository, ActivityRepository activityRepository) {
		this.workoutRepository = workoutRepository;
		this.activityRepository = activityRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		
		
		
		// w1 ----------------------------
		// ---------------------- w1 ----------------------
		// ---------------------- w1 ----------------------
		Workout w1 = new Workout();
		w1.setName("Homem Saudável");
		w1.setDetails("Treino para homens sem comorbidades");
		w1.setTarget(ProfileType.HEALTHY_MAN);

		Activity a1 = new Activity();
		a1.setDay(1);
		a1.setWorkout(w1);
		a1.setDetails(
		    "TREINO:\r\n DIA 1: PEITO + TRÍCEPS + CARDIO\r\n" +
		    "-SUPINO RETO 3X12\r\n" +
		    "-FLEXÃO DE BRAÇOS 3X12\r\n" +
		    "-TRÍCEPS MERGULHO 3X12\r\n" +
		    "-CORRIDA LEVE 20MIN"
		);

		Activity a2 = new Activity();
		a2.setDay(2);
		a2.setWorkout(w1);
		a2.setDetails(
		    "DIA 2: COSTAS E BÍCEPS\r\n" +
		    "-PUXADA FRENTE 3X10\r\n" +
		    "-REMADA CURVADA 3X10\r\n" +
		    "-ROSCA DIRETA 3X12\r\n" +
		    "-ALONGAMENTO FINAL 10MIN"
		);

		Activity a3 = new Activity();
		a3.setDay(3);
		a3.setWorkout(w1);
		a3.setDetails(
		    "DIA 3: PERNAS E ABDÔMEN\r\n" +
		    "-AGACHAMENTO 3X12\r\n" +
		    "-LEG PRESS 3X12\r\n" +
		    "-ABDOMINAIS 3X20\r\n" +
		    "-CAMINHADA LEVE 10MIN"
		);

		Activity a4 = new Activity();
		a4.setDay(4);
		a4.setWorkout(w1);
		a4.setDetails(
		    "DIA 4: CARDIO E RESISTÊNCIA\r\n" +
		    "-CORRIDA 10MIN\r\n" +
		    "-ALONGAMENTO GERAL 10MIN"
		);

		Activity a5 = new Activity();
		a5.setDay(5);
		a5.setWorkout(w1);
		a5.setDetails(
		    "DIA 5: TREINO FUNCIONAL\r\n" +
		    "-CIRCUITO: AGACHAMENTO, PRANCHA, CORRIDA, BARRA\r\n" +
		    "-ALONGAMENTO 10MIN"
		);

		//activityRepository.saveAll(Arrays.asList(a1, a2, a3, a4, a5));
		w1.getWorkout().addAll(Arrays.asList(a1, a2, a3, a4, a5));


		// ---------------------- w2 ----------------------
		Workout w2 = new Workout();
		w2.setName("Mulher Saudável");
		w2.setDetails("Treino para mulheres sem comorbidades");
		w2.setTarget(ProfileType.HEALTHY_WOMEN);

		Activity b1 = new Activity();
		b1.setDay(1);
		b1.setWorkout(w2);
		b1.setDetails(
		    "TREINO:\r\n DIA 1: PERNAS E GLÚTEO\r\n" +
		    "-CAMINHADA 10MIN\r\n" +
		    "-AGACHAMENTO COM PESO 3X12\r\n" +
		    "-LEG PRESS 3X15\r\n" +
		    "-CADEIRA ABDUTORA 3X15\r\n" +
		    "-STIFF 3X12\r\n" +
		    "-ELEVAÇÃO PÉLVICA 3X15\r\n" +
		    "-ALONGAMENTO DE PERNAS E QUADRIL"
		);

		Activity b2 = new Activity();
		b2.setDay(2);
		b2.setWorkout(w2);
		b2.setDetails(
		    "DIA 2: BRAÇOS E OMBROS\r\n" +
		    "-CORDA OU ELÍPTICO 10MIN\r\n" +
		    "-DESENVOLVIMENTO DE OMBRO\r\n" +
		    "-ROSCA DIRETA 3X12\r\n" +
		    "-TRÍCEPS PULLEY 3X12\r\n" +
		    "-REMADA BAIXA 3X12\r\n" +
		    "-ELEVAÇÃO LATERAL DE OMBRO 3X15\r\n" +
		    "-ALONGAMENTO DE BRAÇOS 10MIN"
		);

		Activity b3 = new Activity();
		b3.setDay(3);
		b3.setWorkout(w2);
		b3.setDetails(
		    "DIA 3: CARDIO E ABDÔMEN\r\n" +
		    "-CORRIDA LEVE 30MIN\r\n" +
		    "-PRANCHA 3X30S\r\n" +
		    "-ABDOMINAL INFRA 3X15\r\n" +
		    "-ABDOMINAL OBLÍQUO 3X20"
		);

		Activity b4 = new Activity();
		b4.setDay(4);
		b4.setWorkout(w2);
		b4.setDetails(
		    "DIA 4: FULL BODY\r\n" +
		    "-CORRIDA 10MIN\r\n" +
		    "-CIRCUITO: 3 A 4 VOLTAS\r\n" +
		    "    -AGACHAMENTO\r\n" +
		    "    -FLEXÃO DE BRAÇO\r\n" +
		    "    -CORRIDA NO LUGAR\r\n" +
		    "    -PRANCHA COM TOQUE NO OMBRO\r\n" +
		    "    -PONTE DE GLÚTEO"
		);
		//activityRepository.saveAll(Arrays.asList(b1, b2, b3, b4));
		w2.getWorkout().addAll(Arrays.asList(b1, b2, b3, b4));


		// ---------------------- w3 ----------------------
		Workout w3 = new Workout();
		w3.setName("Pessoa de idade avançada");
		w3.setDetails("Treino para idosos");
		w3.setTarget(ProfileType.ELDERLY_PERSON);

		Activity c1 = new Activity();
		c1.setDay(1);
		c1.setWorkout(w3);
		c1.setDetails(
		    "TREINO:\r\n DIA 1: FORÇA E ESTABILIDADE\r\n" +
		    "-BICICLETA ERGOMÉTRICA 10MIN\r\n" +
		    "-AGACHAMENTO PARCIAL 3X10\r\n" +
		    "-ELEVAÇÃO DE PERNAS 3X12\r\n" +
		    "-ALONGAMENTO 10MIN"
		);

		Activity c2 = new Activity();
		c2.setDay(2);
		c2.setWorkout(w3);
		c2.setDetails(
		    "DIA 2: MOBILIDADE E RESISTÊNCIA LEVE\r\n" +
		    "-CAMINHADA LEVE 15MIN\r\n" +
		    "-EXERCÍCIOS COM ELÁSTICO: OMBRO, BÍCEPS E TRÍCEPS 3X12\r\n" +
		    "-PILATES BÁSICO 20MIN\r\n" +
		    "-ALONGAMENTOS 10MIN"
		);

		Activity c3 = new Activity();
		c3.setDay(3);
		c3.setWorkout(w3);
		c3.setDetails(
		    "DIA 3: RECUPERAÇÃO ATIVA\r\n" +
		    "-HIDROGINÁSTICA OU CAMINHADA LEVE\r\n" +
		    "-ALONGAMENTOS SUAVES 10MIN"
		);

		Activity c4 = new Activity();
		c4.setDay(4);
		c4.setWorkout(w3);
		c4.setDetails(
		    "DIA 4: CORE E EQUILÍBRIO\r\n" +
		    "-PRANCHA 3X20S\r\n" +
		    "-PONTE DE GLÚTEO 3X15\r\n" +
		    "-EXERCÍCIOS DE EQUILÍBRIO COM APOIO 3X10"
		);

		//activityRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
		w3.getWorkout().addAll(Arrays.asList(c1, c2, c3, c4));


		// ---------------------- w4 ----------------------
		Workout w4 = new Workout();
		w4.setName("Pessoa com problemas de juntas e ossos");
		w4.setDetails("Treino para pessoas com problemas de juntas e/ou ossos");
		w4.setTarget(ProfileType.JOINT_ISSUE_PERSON);

		Activity d1 = new Activity();
		d1.setDay(1);
		d1.setWorkout(w4);
		d1.setDetails(
		    "TREINO:\r\n DIA 1:\r\n" +
		    "-CAMINHADA 10MIN\r\n" +
		    "-PONTE DE GLÚTEO 3X15\r\n" +
		    "-EXTENSÃO LOMBAR 3X12\r\n" +
		    "-ALONGAMENTO 10MIN"
		);

		Activity d2 = new Activity();
		d2.setDay(2);
		d2.setWorkout(w4);
		d2.setDetails(
		    "DIA 2:\r\n" +
		    "-BICICLETA\r\n" +
		    "-REMADA ELÁSTICA 3X12\r\n" +
		    "-ELEVAÇÃO DE BRAÇOS 3X12\r\n" +
		    "-ALONGAMENTO DE COSTAS E OMBROS"
		);

		Activity d3 = new Activity();
		d3.setDay(3);
		d3.setWorkout(w4);
		d3.setDetails(
		    "DIA 3:\r\n" +
		    "-CAMINHADA\r\n" +
		    "-EXERCÍCIOS DE EQUILÍBRIO\r\n" +
		    "-ALONGAMENTO DINÂMICO"
		);
		//activityRepository.saveAll(Arrays.asList(d1, d2, d3));
		w4.getWorkout().addAll(Arrays.asList(d1, d2, d3));


		// ---------------------- w5 ----------------------
		Workout w5 = new Workout();
		w5.setName("Pessoa com problemas de coração e pulmão");
		w5.setDetails("Treino para pessoas com problemas de coração e/ou pulmão");
		w5.setTarget(ProfileType.HEART_OR_LUNG_ISSUE_PERSON);

		Activity e1 = new Activity();
		e1.setDay(1);
		e1.setWorkout(w5);
		e1.setDetails(
		    "TREINO:\r\n DIA 1: PEITO E TRÍCEPS + CARDIO\r\n" +
		    "-SUPINO RETO 3X10\r\n" +
		    "-FLEXÃO DE BRAÇOS 3X12\r\n" +
		    "-TRÍCEPS MERGULHO 3X12\r\n" +
		    "-CORRIDA LEVE 20MIN"
		);

		Activity e2 = new Activity();
		e2.setDay(2);
		e2.setWorkout(w5);
		e2.setDetails(
		    "DIA 2: COSTAS E BÍCEPS\r\n" +
		    "-PUXADA FRENTE 3X10\r\n" +
		    "-REMADA CURVADA 3X10\r\n" +
		    "-ROSCA DIRETA 3X12\r\n" +
		    "-ALONGAMENTO FINAL 10MIN"
		);

		Activity e3 = new Activity();
		e3.setDay(3);
		e3.setWorkout(w5);
		e3.setDetails(
		    "DIA 3: PERNAS E CORE\r\n" +
		    "-AGACHAMENTO 3X12\r\n" +
		    "-LEG PRESS 3X12\r\n" +
		    "-ABDOMINAL 3X20\r\n" +
		    "-CAMINHADA"
		);

		Activity e4 = new Activity();
		e4.setDay(4);
		e4.setWorkout(w5);
		e4.setDetails(
		    "DIA 4: CARDIO E RESISTÊNCIA\r\n" +
		    "-CORRIDA OU BICICLETA 40MIN\r\n" +
		    "-ALONGAMENTO EM GERAL"
		);

		Activity e5 = new Activity();
		e5.setDay(5);
		e5.setWorkout(w5);
		e5.setDetails(
		    "DIA 5: TREINO FUNCIONAL\r\n" +
		    "-AGACHAMENTO\r\n" +
		    "-PRANCHA\r\n" +
		    "-CORRIDA ESTACIONÁRIA\r\n" +
		    "-ALONGAMENTO"
		);
		
		//activityRepository.saveAll(Arrays.asList(e1, e2, e3, e4, e5));
		w5.getWorkout().addAll(Arrays.asList(e1, e2, e3, e4, e5));


		// ---------------------- Salvar todos ----------------------
		workoutRepository.saveAll(Arrays.asList(w1, w2, w3, w4, w5));
	}
}
