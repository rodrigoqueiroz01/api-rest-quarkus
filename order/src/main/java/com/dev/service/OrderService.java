package com.dev.service;

import com.dev.client.*;
import com.dev.dto.OrderDTO;
import com.dev.repository.OrderRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import java.util.*;

import static com.dev.mapper.OrderMapper.*;

@ApplicationScoped
public class OrderService {

    @Inject
    OrderRepository repository;

    @Inject
    CustomerClient customerClient;

    @Inject
    ProductClient productClient;

    public List<OrderDTO> getAllOrders() {
        List<OrderDTO> orders = new ArrayList<>();

        repository.findAll().stream().forEach(item -> {
            orders.add(fromOrderToOrderDTO(item));
        });

        return orders;
    }

    @Transactional
    public void save(OrderDTO order) {
        var customer = customerClient.findCustomerById(order.getCustomerId());

        if (customer.getName().equals(order.getCustomerName())
                && productClient.findProductById(order.getProductId()) != null) {
            repository.persist(fromOrderDTOToOrder(order));
        } else {
            throw new NotFoundException("Pedido não encontrado");
        }

    }

    @Transactional
    public void update(Long id, OrderDTO dto) {
        var order = repository.findById(id);
        order.setCustomerId(dto.getCustomerId());
        order.setCustomerName(dto.getCustomerName());
        order.setProductId(dto.getProductId());
        order.setOrderValue(dto.getOrderValue());

        repository.persist(order);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
