package repository;

import dto.PublisherRequestDto;
import dto.PublisherResponseDto;
import model.Publisher;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PublisherRepositoryImpl implements PublisherRepository {
    private static List<Publisher> publishers = new ArrayList<>();

    @Override
    public void save(PublisherRequestDto publisherRequestDto) {
        Publisher publisher = new Publisher(publisherRequestDto.getName(), publisherRequestDto.getCreateDate());
        publishers.add(publisher);
    }

    @Override
    public List<PublisherResponseDto> getAll() {
        List<PublisherResponseDto> publisherResponseDtoList = new ArrayList<>();
        publishers.forEach(publisher -> {
            PublisherResponseDto publisherResponseDto = new PublisherResponseDto();
            publisherResponseDto.setName(publisher.getName());
            publisherResponseDto.setCreateDate(publisher.getCreateDate());
            publisherResponseDto.setBookList(publisher.getBookList());
            publisherResponseDtoList.add(publisherResponseDto);
        });
        return publisherResponseDtoList;
    }

    @Override
    public Optional<Publisher> getByName(String publisherName){
        return publishers.stream()
                .filter(publisher -> publisher.getName().equals(publisherName))
                .findFirst();
    }

}
