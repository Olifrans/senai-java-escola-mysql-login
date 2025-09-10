package com.senai.escola.Controller;

import com.senai.escola.Models.Aluno;
import com.senai.escola.Models.Professor;
import com.senai.escola.Service.AlunoService;
import com.senai.escola.Service.ProfessorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/professores")
public class ProfessorController {
    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }


    @GetMapping
    public List<Professor> buscarProfessores(){
        return professorService.buscarTodosProfessores();
    }

    @PostMapping
    public Professor salvar(@RequestBody Professor professor){
        return professorService.salvarNovoProfessor(professor);
    }



    @PutMapping("/{id}")
    public Professor atualizarProfessores(@PathVariable Long id,@RequestBody Professor novoProfessor){

        Professor verificaProfessor = professorService.buscarProfessorId(id);
        if (verificaProfessor == null) return null;

        verificaProfessor.setNome(novoProfessor.getNome());
        verificaProfessor.setEmail(novoProfessor.getEmail());
        verificaProfessor.setTelefone(novoProfessor.getTelefone());

        return professorService.salvarNovoProfessor(verificaProfessor);
    }




    @DeleteMapping("/{id}")
    public void excluirAluno(@PathVariable Long id){
        professorService.deletarProfessor(id);
    }


    @GetMapping("/{id}")
    public Professor buscaAlunoPorId(@PathVariable Long id){
        return professorService.buscarProfessorId(id);
    }



}
