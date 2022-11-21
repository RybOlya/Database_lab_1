package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.domain.IpAddress;
import ua.lviv.iot.dto.IpAddressDto;
import ua.lviv.iot.dto.assembler.IpAddressDtoAssembler;
import ua.lviv.iot.service.IpAddressService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/ipaddresses")
public class IpAddressController {
    @Autowired
    private IpAddressService ipAddressService;
    @Autowired
    private IpAddressDtoAssembler ipAddressDtoAssembler;

    @GetMapping(value = "/{ipAddressId}")
    public ResponseEntity<IpAddressDto> getIpAddress(@PathVariable Integer ipAddressId) {
        IpAddress ipAddress = ipAddressService.findById(ipAddressId);
        IpAddressDto ipAddressDto = ipAddressDtoAssembler.toModel(ipAddress);
        return new ResponseEntity<>(ipAddressDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<IpAddressDto>> getAllIpAddresses() {
        List<IpAddress> ipAddresses = ipAddressService.findAll();
        CollectionModel<IpAddressDto> ipAddressDtos = ipAddressDtoAssembler.toCollectionModel(ipAddresses);
        return new ResponseEntity<>(ipAddressDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<IpAddressDto> addIpAddress(@RequestBody IpAddress ipAddress) {
        IpAddress newIpAddress = ipAddressService.create(ipAddress);
        IpAddressDto ipAddressDto = ipAddressDtoAssembler.toModel(newIpAddress);
        return new ResponseEntity<>(ipAddressDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{ipAddressId}")
    public ResponseEntity<?> updateIpAddress(@RequestBody IpAddress uIpAddress, @PathVariable Integer ipAddressId) {
        ipAddressService.update(ipAddressId, uIpAddress);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{ipAddressId}")
    public ResponseEntity<?> deleteIpAddress(@PathVariable Integer ipAddressId) {
        ipAddressService.delete(ipAddressId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/insertTenRowsInIpAddress")
    public void insertTenRowsInIpAddress(){
        ipAddressService.insertTenRowsInIpAddress();
    }

}
