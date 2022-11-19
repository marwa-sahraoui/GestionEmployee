package com.example.gestionemployee.controller;

//@RestController
//public class ClientController {
//
//    final ClientService clientService;
//
//    public ClientController(ClientService clientService) {
//        this.clientService = clientService;
//    }
//    @GetMapping("/clients")
//    public List<Client> findAll() {
//        return clientService.findAll();
//    }
//    @GetMapping("/id")
//    public Client findById (@PathVariable Long id){
//        return clientService.findById(id);
//    }
//    @PostMapping(path ="/add")
//    public Client save(@RequestBody Client client){
//        return clientService.save(client);
//    }
//    @PutMapping("/{id}")
//    public void updateClient(@PathVariable Long id, @RequestBody  Client client){
//        clientService.update( client, id);
//    }
//    @DeleteMapping("/{id}")
//    public void deleteById(@PathVariable Long id){
//        clientService.deleteById(id);
//    }
//
//}
