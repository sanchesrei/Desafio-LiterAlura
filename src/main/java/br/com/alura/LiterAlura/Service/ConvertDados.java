package br.com.alura.LiterAlura.Service;

import tools.jackson.databind.ObjectMapper;

public class ConvertDados implements IConverteDados {
    private ObjectMapper mapper = new ObjectMapper();


    @Override
    public <T> T obterDados(String json, Class<T> classe) {
       try{
           return mapper.readValue(json, classe);
       } catch (Exception e){
           throw new RuntimeException("Erro ao converte dados: "+ e.getMessage());
       }

    }
}
