package com.interviewPrep.Project.Controller;

import com.interviewPrep.Project.NeDetailsDto.NetworkElementsDto;
import com.interviewPrep.Project.Service.impl.NetworkElementService;
import com.interviewPrep.Project.entities.NetworkElement;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequiredArgsConstructor
@RequestMapping("NeDetails")
public class NeRestController {

    private Map<Integer,NetworkElement> map = new HashMap<>();
    @Autowired
    private NetworkElementService networkElementService;

    @GetMapping
    public ResponseEntity<List<NetworkElementsDto>>  getDetails(){
        return ResponseEntity.ok().body(networkElementService.getAllNetworkElement());
    }

    @GetMapping("/top10NetworkElements")
    public ResponseEntity<List<NetworkElementsDto>>  getTopTenDetails(){
        return ResponseEntity.ok().body(networkElementService.getenNetworkElement());
    }

    @PostMapping
    public ResponseEntity<String> createNetworkElement(@RequestBody List<NetworkElementsDto> networkElementsDtos){

        for(NetworkElementsDto networkElementsDto : networkElementsDtos){
            if (networkElementsDto.getIp()!=0 ) {
                networkElementService.insertAllNetworkElements(networkElementsDto);
            }else
                throw new IllegalArgumentException(String.valueOf(networkElementsDto.getIp()));
        }
        return ResponseEntity.ok("Network element created successfully ✅");
    }

    @GetMapping("/withNetworkElement/{ip}")
    public ResponseEntity<NetworkElement> getNetworkElementByIp(@PathVariable int ip){
        NetworkElement element = map.get(ip);
        if (element!= null){
            return ResponseEntity.ok(map.get(ip));
        }else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping("/{ip}")
    public ResponseEntity deleteNetworkElement(@PathVariable int ip){
        networkElementService.deleteNetworkElement(ip);
        return ResponseEntity.ok("Ip has been deleted");
    }
    //GET /products?category_id=5&search=phone&page=1&limit=20
    @GetMapping
    public ResponseEntity<String> getProducts(
            @RequestParam(required = false) Long category_id,
            @RequestParam(required = false) String search,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "20") int limit) {

        String response = String.format(
                "Filtering products -> category_id: %s, search: %s, page: %d, limit: %d",
                category_id, search, page, limit
        );

        return ResponseEntity.ok(response);
    }

}
