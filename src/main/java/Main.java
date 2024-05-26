import dto.*;
import factory.GenerateRandomUnique;
import factory.service.*;
import model.enums.AccountType;
import model.enums.ProductType;
import model.enums.ServiceType;
import service.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<UserRequestDto> userRequestDtoList = new ArrayList<>();
        UserRequestDto userRequestDto1 = new UserRequestDto();
        userRequestDto1.setName("cem");
        userRequestDto1.setSurname("dırman");
        userRequestDto1.setEmail("cemdirman@gmail.com");
        userRequestDto1.setPhoneNumber("05051234567");
        userRequestDto1.setPassword(GenerateRandomUnique.createRandomHash("987654321"));
        userRequestDto1.setAddress("istanbul");
        userRequestDto1.setBirthDate(LocalDate.of(1995, Month.JANUARY, 1));
        userRequestDtoList.add(userRequestDto1);

        UserRequestDto userRequestDto2 = new UserRequestDto();
        userRequestDto2.setName("senol");
        userRequestDto2.setSurname("karakurt");
        userRequestDto2.setEmail("senolkarakurt@gmail.com");
        userRequestDto2.setPhoneNumber("05051234567");
        userRequestDto2.setPassword(GenerateRandomUnique.createRandomHash("987654321"));
        userRequestDto2.setAddress("ankara");
        userRequestDto2.setBirthDate(LocalDate.of(1994, Month.JANUARY, 1));
        userRequestDtoList.add(userRequestDto2);

        UserRequestDto userRequestDto3 = new UserRequestDto();
        userRequestDto3.setName("ahmet");
        userRequestDto3.setSurname("daşdelen");
        userRequestDto3.setEmail("ahmetdasdelen@gmail.com");
        userRequestDto3.setPhoneNumber("05051234567");
        userRequestDto3.setPassword(GenerateRandomUnique.createRandomHash("987654321"));
        userRequestDto3.setAddress("izmir");
        userRequestDto3.setBirthDate(LocalDate.of(1990, Month.JANUARY, 1));;
        userRequestDtoList.add(userRequestDto3);

        UserRequestDto userRequestDto4 = new UserRequestDto();
        userRequestDto4.setName("AHMET HAMDİ");
        userRequestDto4.setSurname("TANPINAR");
        userRequestDto4.setEmail("ahmethamditanpinar@gmail.com");
        userRequestDto4.setPhoneNumber("05051234567");
        userRequestDto4.setPassword(GenerateRandomUnique.createRandomHash("987654321"));
        userRequestDto4.setAddress("bursa");
        userRequestDto4.setBirthDate(LocalDate.of(1985, Month.JANUARY, 1));
        userRequestDtoList.add(userRequestDto4);

        UserRequestDto userRequestDto5 = new UserRequestDto();
        userRequestDto5.setName("MURAT");
        userRequestDto5.setSurname("TAŞKIRAN");
        userRequestDto5.setEmail("murattaskiran@gmail.com");
        userRequestDto5.setPhoneNumber("05051234567");
        userRequestDto5.setPassword(GenerateRandomUnique.createRandomHash("987654321"));
        userRequestDto5.setAddress("adana");
        userRequestDto5.setBirthDate(LocalDate.of(1975, Month.JANUARY, 1));
        userRequestDtoList.add(userRequestDto5);

        UserRequestDto userRequestDto6 = new UserRequestDto();
        userRequestDto6.setName("MEHMET");
        userRequestDto6.setSurname("BAKIR");
        userRequestDto6.setEmail("mehmetbakir@gmail.com");
        userRequestDto6.setPhoneNumber("05051234567");
        userRequestDto6.setPassword(GenerateRandomUnique.createRandomHash("987654321"));
        userRequestDto6.setAddress("antalya");
        userRequestDto6.setBirthDate(LocalDate.of(1980, Month.JANUARY, 1));
        userRequestDtoList.add(userRequestDto6);

        UserServiceFactory userServiceFactory = new UserServiceFactory();
        UserService userService = userServiceFactory.getBaseService(ServiceType.USER);
        if (userService == null){
            throw new RuntimeException("user service not found");
        }
        userRequestDtoList.forEach(userService::save);

        System.out.println("\nUSER LIST\n");
        userService.getAll().forEach(System.out::println);
        System.out.println("\n--------------\n");

        List<CustomerRequestDto> customerRequestDtoList = new ArrayList<>();
        CustomerRequestDto customerRequestDto1 = new CustomerRequestDto();
        customerRequestDto1.setUserRequestDto(userRequestDto1);
        customerRequestDto1.setCredit(0);
        customerRequestDto1.setAccountType(AccountType.STANDARD);
        customerRequestDtoList.add(customerRequestDto1);

        CustomerRequestDto customerRequestDto2 = new CustomerRequestDto();
        customerRequestDto2.setUserRequestDto(userRequestDto2);
        customerRequestDto2.setCredit(0);
        customerRequestDto2.setAccountType(AccountType.STANDARD);
        customerRequestDtoList.add(customerRequestDto2);

        CustomerRequestDto customerRequestDto3 = new CustomerRequestDto();
        customerRequestDto3.setUserRequestDto(userRequestDto3);
        customerRequestDto3.setCredit(0);
        customerRequestDto3.setAccountType(AccountType.STANDARD);
        customerRequestDtoList.add(customerRequestDto3);

        CustomerServiceFactory customerServiceFactory = new CustomerServiceFactory();
        CustomerService customerService = customerServiceFactory.getBaseService(ServiceType.CUSTOMER);
        if (customerService == null){
            throw new RuntimeException("customer service not found");
        }
        customerRequestDtoList.forEach(customerService::save);

        System.out.println("\nCUSTOMER LIST\n");
        customerService.getAll().forEach(System.out::println);
        System.out.println("\n--------------\n");

        List<PublisherRequestDto> publisherRequestDtoList = new ArrayList<>();

        PublisherRequestDto publisherRequestDto1 = new PublisherRequestDto();
        publisherRequestDto1.setName("DERGAH YAYINLARI");
        publisherRequestDto1.setCreateDate(LocalDate.now().minusYears(1));
        publisherRequestDtoList.add(publisherRequestDto1);

        PublisherRequestDto publisherRequestDto2 = new PublisherRequestDto();
        publisherRequestDto2.setName("CAN YAYINLARI");
        publisherRequestDto2.setCreateDate(LocalDate.now().minusYears(10));
        publisherRequestDtoList.add(publisherRequestDto2);

        PublisherRequestDto publisherRequestDto3 = new PublisherRequestDto();
        publisherRequestDto3.setName("EMEK YAYINLARI");
        publisherRequestDto3.setCreateDate(LocalDate.now().minusYears(5));
        publisherRequestDtoList.add(publisherRequestDto3);

        PublisherServiceFactory publisherServiceFactory = new PublisherServiceFactory();
        PublisherService publisherService = publisherServiceFactory.getBaseService(ServiceType.PUBLISHER);
        if (publisherService == null){
            throw new RuntimeException("publisher service not found");
        }
        publisherRequestDtoList.forEach(publisherService::save);

        System.out.println("\nPUBLISHER LIST\n");
        publisherService.getAll().forEach(System.out::println);
        System.out.println("\n--------------\n");
        System.out.println(publisherService.hashCode());

        List<AuthorRequestDto> authorRequestDtoList = new ArrayList<>();
        AuthorRequestDto authorRequestDto1 = new AuthorRequestDto();
        authorRequestDto1.setUserRequestDto(userRequestDto4);
        authorRequestDtoList.add(authorRequestDto1);

        AuthorRequestDto authorRequestDto2 = new AuthorRequestDto();
        authorRequestDto2.setUserRequestDto(userRequestDto5);
        authorRequestDtoList.add(authorRequestDto2);

        AuthorRequestDto authorRequestDto3 = new AuthorRequestDto();
        authorRequestDto3.setUserRequestDto(userRequestDto6);
        authorRequestDtoList.add(authorRequestDto3);

        AuthorServiceFactory authorServiceFactory = new AuthorServiceFactory();
        AuthorService authorService = authorServiceFactory.getBaseService(ServiceType.AUTHOR);
        if (authorService == null){
            throw new RuntimeException("author service not found");
        }
        authorRequestDtoList.forEach(authorService::save);

        System.out.println("\nAUTHOR LIST\n");
        authorService.getAll().forEach(System.out::println);
        System.out.println("\n--------------\n");
        System.out.println(authorService.hashCode());

        List<CategoryRequestDto> categoryRequestDtoList = new ArrayList<>();
        CategoryRequestDto categoryRequestDto1 = new CategoryRequestDto();
        categoryRequestDto1.setName("HIKAYE");
        categoryRequestDto1.setDescription("Hikaye kategorisidir");
        categoryRequestDtoList.add(categoryRequestDto1);

        CategoryRequestDto categoryRequestDto2 = new CategoryRequestDto();
        categoryRequestDto2.setName("ROMAN");
        categoryRequestDto2.setDescription("Roman kategorisidir");
        categoryRequestDtoList.add(categoryRequestDto2);

        CategoryRequestDto categoryRequestDto3 = new CategoryRequestDto();
        categoryRequestDto3.setName("BILIM");
        categoryRequestDto3.setDescription("Bilim kategorisidir");
        categoryRequestDtoList.add(categoryRequestDto3);

        CategoryServiceFactory categoryServiceFactory = new CategoryServiceFactory();
        CategoryService categoryService = categoryServiceFactory.getBaseService(ServiceType.CATEGORY);
        if (categoryService == null){
            throw new RuntimeException("category service not found");
        }
        categoryRequestDtoList.forEach(categoryService::save);

        System.out.println("\nCATEGORY LIST\n");
        categoryService.getAll().forEach(System.out::println);
        System.out.println("\n--------------\n");

        List<ProductRequestDto> productRequestDtoList = new ArrayList<>();
        ProductRequestDto productRequestDto1 = new ProductRequestDto();
        productRequestDto1.setName("Şeker Portakalı");
        productRequestDto1.setAmount(new BigDecimal("190.20"));
        productRequestDto1.setProductType(ProductType.BOOK);
        productRequestDto1.setCategoryRequestDto(categoryRequestDto1);
        productRequestDto1.setStock(100);
        productRequestDto1.setPublisherRequestDto(publisherRequestDto1);
        productRequestDto1.setAuthorRequestDto(authorRequestDto1);
        productRequestDto1.setDescription("Ne güzel bir şeker portakalı fidanıymış bu! " +
                "Hem bak, dikeni de yok. Pek de kişilik sahibiymiş, şeker portakalı olduğu " +
                "ta uzaktan belli. Ben senin boyunda olsaydım başka şey istemezdim.”\n" +
                "“Ama ben büyük bir ağaç istiyordum.");
        productRequestDtoList.add(productRequestDto1);


        ProductRequestDto productRequestDto2 = new ProductRequestDto();
        productRequestDto2.setName("Saatleri Ayarlama Enstitüsü");
        productRequestDto2.setAmount(new BigDecimal("90.20"));
        productRequestDto2.setProductType(ProductType.BOOK);
        productRequestDto2.setCategoryRequestDto(categoryRequestDto2);
        productRequestDto2.setStock(200);
        productRequestDto2.setPublisherRequestDto(publisherRequestDto2);
        productRequestDto2.setAuthorRequestDto(authorRequestDto2);
        productRequestDto2.setDescription("Ne güzel bir şeker portakalı fidanıymış bu! " +
                "Hem bak, dikeni de yok. Pek de kişilik sahibiymiş, şeker portakalı olduğu " +
                "ta uzaktan belli. Ben senin boyunda olsaydım başka şey istemezdim.”\n" +
                "“Ama ben büyük bir ağaç istiyordum.");
        productRequestDtoList.add(productRequestDto2);


        ProductRequestDto productRequestDto3 = new ProductRequestDto();
        productRequestDto3.setName("Küçük Prens");
        productRequestDto3.setAmount(new BigDecimal("240"));
        productRequestDto3.setProductType(ProductType.JOURNAL);
        productRequestDto3.setCategoryRequestDto(categoryRequestDto3);
        productRequestDto3.setStock(300);
        productRequestDto3.setPublisherRequestDto(publisherRequestDto3);
        productRequestDto3.setAuthorRequestDto(authorRequestDto3);
        productRequestDto3.setDescription("Ne güzel bir şeker portakalı fidanıymış bu! " +
                "Hem bak, dikeni de yok. Pek de kişilik sahibiymiş, şeker portakalı olduğu " +
                "ta uzaktan belli. Ben senin boyunda olsaydım başka şey istemezdim.”\n" +
                "“Ama ben büyük bir ağaç istiyordum.");
        productRequestDtoList.add(productRequestDto3);

        ProductService productService = new ProductServiceImpl(publisherService, authorService);
        productRequestDtoList.forEach(productService::save);

        System.out.println("\nPRODUCT LIST\n");
        productService.getAll().forEach(System.out::println);
        System.out.println("\n--------------\n");

        List<OrderRequestDto> orderRequestDtoList = new ArrayList<>();
        OrderRequestDto orderRequestDto = new OrderRequestDto();
        orderRequestDto.setProductRequestDtoList(productRequestDtoList);
        orderRequestDto.setCustomerRequestDto(customerRequestDto1);
        orderRequestDtoList.add(orderRequestDto);

        List<CustomerRequestDto> customerRequestDtoListForOrder = new ArrayList<>();
        CustomerRequestDto customerRequestDto1ForOrder = new CustomerRequestDto();
        customerRequestDto1ForOrder.setUserRequestDto(userRequestDto1);
        customerRequestDto1ForOrder.setOrderRequestDtoList(orderRequestDtoList);
        customerRequestDtoListForOrder.add(customerRequestDto1ForOrder);

        OrderServiceFactory orderServiceFactory = new OrderServiceFactory();
        OrderService orderService = orderServiceFactory.getBaseService(ServiceType.ORDER);
        if (orderService == null){
            throw new RuntimeException("order service not found");
        }
        customerRequestDtoListForOrder.forEach(orderService::save);

        System.out.println("\nORDER LIST\n");
        orderService.getAll().forEach(System.out::println);
        System.out.println("\n--------------\n");

        InvoiceServiceFactory invoiceServiceFactory = new InvoiceServiceFactory();
        InvoiceService invoiceService = invoiceServiceFactory.getBaseService(ServiceType.INVOICE);
        if (invoiceService == null){
            throw new RuntimeException("invoice service not found");
        }

        System.out.println("\nINVOICE LIST\n");
        int orderedProductCountForCustomer = 0;
        for (InvoiceResponseDto invoiceResponseDto:invoiceService.getAll()){
            System.out.println(invoiceResponseDto.getTotalPrice());
            System.out.println(invoiceResponseDto.getOrderResponseDto().getOrderCode());
            System.out.println(invoiceResponseDto.getOrderResponseDto().getCustomerResponseDto().getUserResponseDto().getName());
            System.out.println(invoiceResponseDto.getOrderResponseDto().getCustomerResponseDto().getUserResponseDto().getSurname());
            System.out.println(invoiceResponseDto.getOrderResponseDto().getCustomerResponseDto().getUserResponseDto().getEmail());
            System.out.println(invoiceResponseDto.getOrderResponseDto().getCreateDateTime());
            System.out.println(invoiceResponseDto.getOrderResponseDto().getOrderStatus().toString());
            if ("cem".equals(invoiceResponseDto.getOrderResponseDto().getCustomerResponseDto().getUserResponseDto().getName())){
                orderedProductCountForCustomer++;
            }
        }
        System.out.println("\n--------------\n");

        System.out.println("\nTüm müşteri sayısı");
        int allCustomerCount = customerService.getAll().size();
        System.out.println(allCustomerCount + " tane müşteri bulunmaktadır.");

        System.out.println("\nİsmi Cem olan müşterilerin aldıkları ürün sayısı: " + orderedProductCountForCustomer);

        BigDecimal totalAmountForOrder = invoiceService.getAll()
                .stream()
                .filter(invoiceResponseDto -> "cem".equals(invoiceResponseDto.getOrderResponseDto().getCustomerResponseDto().getUserResponseDto().getName()))
                .filter(invoiceResponseDto -> {
                    LocalDate curDate = LocalDate.now();
                    LocalDate birthDate = invoiceResponseDto.getOrderResponseDto().getCustomerResponseDto().getUserResponseDto().getBirthDate();
                    Integer age = Period.between(birthDate, curDate).getYears();
                    return age.compareTo(30) < 0 && age.compareTo(25) > 0;
                })
                .map(InvoiceResponseDto::getOrderResponseDto)
                .flatMap(orderResponseDto -> orderResponseDto.getProductResponseDtoList().stream())
                .map(ProductResponseDto::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("İsmi Cem olup yaşı 30’dan küçük 25’ten büyük müşterilerin toplam alışveriş tutarı: " + totalAmountForOrder);

        List<InvoiceResponseDto> invoiceResponseDtoListForGreaterThan1500 = invoiceService.getAll()
                .stream()
                .filter(invoiceResponseDto -> invoiceResponseDto.getTotalPrice().compareTo(BigDecimal.valueOf(1500)) > 0)
                .toList();

        System.out.println("\n1500 TL üzerindeki faturalar: " + invoiceResponseDtoListForGreaterThan1500.size());
        invoiceResponseDtoListForGreaterThan1500.forEach(System.out::println);
    }
}
