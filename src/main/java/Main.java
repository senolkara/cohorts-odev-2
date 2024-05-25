import dto.AuthorRequestDto;
import dto.CustomerRequestDto;
import dto.ProductRequestDto;
import dto.PublisherRequestDto;
import model.Order;
import model.enums.AccountType;
import service.*;

import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<CustomerRequestDto> customerRequestDtoList = new ArrayList<>();

        CustomerRequestDto customerRequestDto1 = new CustomerRequestDto();
        customerRequestDto1.setName("cem");
        customerRequestDto1.setSurname("dırman");
        customerRequestDto1.setEmail("cem@gmail.com");
        customerRequestDto1.setPhoneNumber("05051234567");
        customerRequestDto1.setPassword(createPasswordHash("987654321"));
        customerRequestDto1.setCredit(0);
        customerRequestDto1.setAccountType(AccountType.STANDARD);

        customerRequestDtoList.add(customerRequestDto1);

        CustomerRequestDto customerRequestDto2 = new CustomerRequestDto();
        customerRequestDto2.setName("senol");
        customerRequestDto2.setSurname("karakurt");
        customerRequestDto2.setEmail("senol@gmail.com");
        customerRequestDto2.setPhoneNumber("05051234567");
        customerRequestDto2.setPassword(createPasswordHash("987654321"));
        customerRequestDto2.setCredit(0);
        customerRequestDto2.setAccountType(AccountType.STANDARD);

        customerRequestDtoList.add(customerRequestDto2);

        CustomerRequestDto customerRequestDto3 = new CustomerRequestDto();
        customerRequestDto3.setName("ahmet");
        customerRequestDto3.setSurname("daşdelen");
        customerRequestDto3.setEmail("ahmet@gmail.com");
        customerRequestDto3.setPhoneNumber("05051234567");
        customerRequestDto3.setPassword(createPasswordHash("987654321"));
        customerRequestDto3.setCredit(0);
        customerRequestDto3.setAccountType(AccountType.STANDARD);

        customerRequestDtoList.add(customerRequestDto3);

        CustomerService customerService = new CustomerServiceImpl();
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

        PublisherService publisherService = new PublisherServiceImpl();
        publisherRequestDtoList.forEach(publisherService::save);

        System.out.println("\nPUBLISHER LIST\n");
        publisherService.getAll().forEach(System.out::println);
        System.out.println("\n--------------\n");
        System.out.println(publisherService.hashCode());


        List<ProductRequestDto> productRequestDtoList = new ArrayList<>();
        ProductRequestDto productRequestDto1 = new ProductRequestDto();
        productRequestDto1.setName("Şeker Portakalı");
        productRequestDto1.setAmount(new BigDecimal("190.20"));
        productRequestDto1.setDescription("Ne güzel bir şeker portakalı fidanıymış bu! " +
                "Hem bak, dikeni de yok. Pek de kişilik sahibiymiş, şeker portakalı olduğu " +
                "ta uzaktan belli. Ben senin boyunda olsaydım başka şey istemezdim.”\n" +
                "“Ama ben büyük bir ağaç istiyordum.");

        PublisherRequestDto publisherRequestDtoForProductRequestDto1 = new PublisherRequestDto();
        publisherRequestDtoForProductRequestDto1.setName("CAN YAYINLARI");
        publisherRequestDtoForProductRequestDto1.setCreateDate(LocalDate.now().minusYears(10));

        productRequestDto1.setPublisherRequestDto(publisherRequestDtoForProductRequestDto1);

        AuthorRequestDto authorRequestDto1 = new AuthorRequestDto();
        authorRequestDto1.setName("AHMET HAMDİ");
        authorRequestDto1.setSurname("TANPINAR");
        authorRequestDto1.setEmail("ahmethamdi@gmail.com");

        productRequestDto1.setAuthorRequestDto(authorRequestDto1);

        productRequestDtoList.add(productRequestDto1);



        ProductRequestDto productRequestDto2 = new ProductRequestDto();
        productRequestDto2.setName("Saatleri Ayarlama Enstitüsü");
        productRequestDto2.setAmount(new BigDecimal("90.20"));
        productRequestDto2.setDescription("Ne güzel bir şeker portakalı fidanıymış bu! " +
                "Hem bak, dikeni de yok. Pek de kişilik sahibiymiş, şeker portakalı olduğu " +
                "ta uzaktan belli. Ben senin boyunda olsaydım başka şey istemezdim.”\n" +
                "“Ama ben büyük bir ağaç istiyordum.");

        PublisherRequestDto publisherRequestDtoForProductRequestDto2 = new PublisherRequestDto();
        publisherRequestDtoForProductRequestDto2.setName("CAN YAYINLARI");
        publisherRequestDtoForProductRequestDto2.setCreateDate(LocalDate.now().minusYears(10));

        productRequestDto2.setPublisherRequestDto(publisherRequestDtoForProductRequestDto2);

        AuthorRequestDto authorRequestDto2 = new AuthorRequestDto();
        authorRequestDto2.setName("MURAT");
        authorRequestDto2.setSurname("TAŞKIRAN");
        authorRequestDto2.setEmail("murat@gmail.com");

        productRequestDto2.setAuthorRequestDto(authorRequestDto2);
        productRequestDtoList.add(productRequestDto2);


        ProductRequestDto productRequestDto3 = new ProductRequestDto();
        productRequestDto3.setName("Küçük Prens");
        productRequestDto3.setAmount(new BigDecimal("240"));
        productRequestDto3.setDescription("Ne güzel bir şeker portakalı fidanıymış bu! " +
                "Hem bak, dikeni de yok. Pek de kişilik sahibiymiş, şeker portakalı olduğu " +
                "ta uzaktan belli. Ben senin boyunda olsaydım başka şey istemezdim.”\n" +
                "“Ama ben büyük bir ağaç istiyordum.");

        PublisherRequestDto publisherRequestDtoForProductRequestDto3 = new PublisherRequestDto();
        publisherRequestDtoForProductRequestDto3.setName("DERGAH YAYINLARI");
        publisherRequestDtoForProductRequestDto3.setCreateDate(LocalDate.now().minusYears(10));

        productRequestDto3.setPublisherRequestDto(publisherRequestDtoForProductRequestDto3);

        AuthorRequestDto authorRequestDto3 = new AuthorRequestDto();
        authorRequestDto3.setName("OSMAN");
        authorRequestDto3.setSurname("BARDAK");
        authorRequestDto3.setEmail("murat@gmail.com");

        productRequestDto3.setAuthorRequestDto(authorRequestDto3);
        productRequestDtoList.add(productRequestDto3);

        ProductService productService = new ProductServiceImpl(publisherService);

        System.out.println("\nPRODUCT LIST\n");
        productRequestDtoList.forEach(productService::save);

        productService.listAll();

        //order
        //System.out.println("\n ORDER LIST \n");

        //customer1.setOrderList(List.of(prepareOrder(List.of(product1, product2)))); çözüm 1

        // customer1.getOrderList().add(prepareOrder(List.of(product1, product2))); // çözüm 2

        // ödev email adresi verilen kullanıcının orderlerini getiren method
        //  listOrdersByEmail("cem@gmail.com");
    }

    /* ödev OrderService oluşturulacak
    private static void listOrdersByEmail(String email) {
        List<Order> orderList = customerList.stream()
                .filter(customer -> customer.getEmail().equals(email))
                .flatMap(customer -> customer.getOrderList().stream())
                .toList();

        orderList.forEach(System.out::println);
    }

     */

//    private static Order prepareOrder(List<Product> productList) {
//        //Order order = new Order(); tercih etmiyoruz. çünkü direkt dönüş yapıyoruz.
//        return new Order(productList, "order123");
//    }

    private static String createPasswordHash(String password){
        String generatedPassword = null;
        try
        {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

}
